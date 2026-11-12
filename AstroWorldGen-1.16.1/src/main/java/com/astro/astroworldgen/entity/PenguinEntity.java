package com.astro.astroworldgen.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/** Ambient penguin adapted from IceUpdate: waddles, swims, follows fish and slides on ice. */
public class PenguinEntity extends CreatureEntity {
    public PenguinEntity(EntityType<? extends PenguinEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        goalSelector.addGoal(2, new TemptGoal(this, 1.0D, Ingredient.fromItems(Items.COD, Items.SALMON), false));
        goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8D));
        goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isRemote && onGround && isSlippery(world.getBlockState(new BlockPos(getPosX(), getPosY() - 0.1D, getPosZ())))) {
            Vector3d motion = getMotion();
            double horizontal = Math.sqrt(motion.x * motion.x + motion.z * motion.z);
            if (horizontal > 0.05D && horizontal < 0.4D) {
                setMotion(motion.x * 1.12D, motion.y, motion.z * 1.12D);
            }
        }
    }

    private static boolean isSlippery(net.minecraft.block.BlockState state) {
        Block block = state.getBlock();
        return block == Blocks.ICE || block == Blocks.PACKED_ICE || block == Blocks.BLUE_ICE
                || block == Blocks.FROSTED_ICE || block == Blocks.SNOW_BLOCK || block == Blocks.SNOW;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }
}
