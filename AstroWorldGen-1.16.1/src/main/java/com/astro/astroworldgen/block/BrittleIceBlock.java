package com.astro.astroworldgen.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/** Fragile cave ice that breaks shortly after a living entity walks over it. */
public class BrittleIceBlock extends Block {
    public BrittleIceBlock() {
        super(Block.Properties.create(Material.ICE, MaterialColor.ICE)
                .hardnessAndResistance(0.3F).slipperiness(0.98F).sound(SoundType.GLASS).notSolid());
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (!world.isRemote && entity instanceof LivingEntity && !entity.isSteppingCarefully()) {
            world.getPendingBlockTicks().scheduleTick(pos, this, 4);
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.destroyBlock(pos, false);
    }
}
