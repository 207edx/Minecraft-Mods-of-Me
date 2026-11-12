package com.astro.astroworldgen.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/** Hanging ice spike that falls when nearby heat melts its support. */
public class IcicleBlock extends Block {
    private static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);

    public IcicleBlock() {
        super(Block.Properties.create(Material.ICE, MaterialColor.ICE)
                .hardnessAndResistance(0.4F).sound(SoundType.GLASS).notSolid().tickRandomly());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockPos above = pos.up();
        BlockState support = world.getBlockState(above);
        return support.getBlock() == this || support.isSolidSide(world, above, Direction.DOWN);
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState,
                                          IWorld world, BlockPos pos, BlockPos facingPos) {
        if (facing == Direction.UP && !state.isValidPosition(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.updatePostPlacement(state, facing, facingState, world, pos, facingPos);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block,
                                BlockPos fromPos, boolean isMoving) {
        if (!world.isRemote) world.getPendingBlockTicks().scheduleTick(pos, this, 10);
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (hasHeat(world, pos)) fall(state, world, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (hasHeat(world, pos)) fall(state, world, pos);
    }

    private static boolean hasHeat(World world, BlockPos pos) {
        for (BlockPos check : BlockPos.getAllInBoxMutable(pos.add(-3, -3, -3), pos.add(3, 3, 3))) {
            BlockState state = world.getBlockState(check);
            Block block = state.getBlock();
            if (state.getMaterial() == Material.FIRE || block == Blocks.TORCH
                    || block == Blocks.WALL_TORCH || block == Blocks.MAGMA_BLOCK
                    || (block == Blocks.CAMPFIRE && state.get(CampfireBlock.LIT))
                    || world.getFluidState(check).isTagged(FluidTags.LAVA)) return true;
        }
        return false;
    }

    private static void fall(BlockState state, ServerWorld world, BlockPos pos) {
        FallingBlockEntity falling = new FallingBlockEntity(world,
                pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, state);
        falling.shouldDropItem = false;
        falling.setHurtEntities(true);
        world.addEntity(falling);
    }
}
