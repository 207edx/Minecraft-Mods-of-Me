package com.astro.astroworldgen.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

/** Small crystal cluster that can attach to floors, walls or ceilings. */
public class IceCrystalBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static final VoxelShape UP = Block.makeCuboidShape(4, 0, 4, 12, 10, 12);
    private static final VoxelShape DOWN = Block.makeCuboidShape(4, 6, 4, 12, 16, 12);
    private static final VoxelShape NORTH = Block.makeCuboidShape(4, 4, 6, 12, 12, 16);
    private static final VoxelShape SOUTH = Block.makeCuboidShape(4, 4, 0, 12, 12, 10);
    private static final VoxelShape EAST = Block.makeCuboidShape(0, 4, 4, 10, 12, 12);
    private static final VoxelShape WEST = Block.makeCuboidShape(6, 4, 4, 16, 12, 12);

    public IceCrystalBlock() {
        super(Block.Properties.create(Material.GLASS, MaterialColor.ICE)
                .hardnessAndResistance(0.4F).sound(SoundType.GLASS)
                .setLightLevel(state -> 5).notSolid());
        setDefaultState(getStateContainer().getBaseState().with(FACING, Direction.UP));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case DOWN: return DOWN;
            case NORTH: return NORTH;
            case SOUTH: return SOUTH;
            case EAST: return EAST;
            case WEST: return WEST;
            default: return UP;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(FACING, context.getFace());
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        Direction facing = state.get(FACING);
        BlockPos support = pos.offset(facing.getOpposite());
        return world.getBlockState(support).isSolidSide(world, support, facing);
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState,
                                          IWorld world, BlockPos pos, BlockPos facingPos) {
        if (facing == state.get(FACING).getOpposite() && !state.isValidPosition(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.updatePostPlacement(state, facing, facingState, world, pos, facingPos);
    }
}
