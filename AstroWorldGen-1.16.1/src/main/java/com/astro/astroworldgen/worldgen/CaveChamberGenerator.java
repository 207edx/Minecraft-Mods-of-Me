package com.astro.astroworldgen.worldgen;

import com.astro.astroworldgen.block.IceCrystalBlock;
import com.astro.astroworldgen.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * One-time themed cave chamber pass for AstroWorldGen biomes.
 *
 * Minecraft 1.16.1 has no separate underground-biome system. This generates
 * biome-specific chambers in newly generated AstroWorldGen biome chunks.
 * A chunk NBT marker prevents repeated carving when a chunk is reopened.
 */
public final class CaveChamberGenerator {
    private static final String MARKER = "astroworldgen_cave_pass_v1";
    private static final Map<World, Set<Long>> PROCESSED =
            Collections.synchronizedMap(new WeakHashMap<World, Set<Long>>());

    private static World overworld(IWorld candidate) {
        if (!(candidate instanceof World)) return null;
        World world = (World) candidate;
        return !world.isRemote && World.OVERWORLD.equals(world.getDimensionKey()) ? world : null;
    }

    private static Set<Long> processed(World world) {
        synchronized (PROCESSED) {
            Set<Long> chunks = PROCESSED.get(world);
            if (chunks == null) {
                chunks = ConcurrentHashMap.newKeySet();
                PROCESSED.put(world, chunks);
            }
            return chunks;
        }
    }

    private static long chunkKey(ChunkPos pos) {
        return ((long) pos.x << 32) ^ (pos.z & 0xffffffffL);
    }

    @SubscribeEvent
    public void onChunkDataLoad(ChunkDataEvent.Load event) {
        World world = overworld(event.getWorld());
        if (world != null && event.getData().getBoolean(MARKER)) {
            processed(world).add(chunkKey(event.getChunk().getPos()));
        }
    }

    @SubscribeEvent
    public void onChunkDataSave(ChunkDataEvent.Save event) {
        World world = overworld(event.getWorld());
        if (world != null && processed(world).contains(chunkKey(event.getChunk().getPos()))) {
            CompoundNBT data = event.getData();
            data.putBoolean(MARKER, true);
        }
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        World world = overworld(event.getWorld());
        if (world == null) return;

        IChunk chunk = event.getChunk();
        ChunkPos cp = chunk.getPos();
        Set<Long> done = processed(world);
        if (done.contains(chunkKey(cp))) return;

        BiomeContainer container = chunk.getBiomes();
        if (container == null) return;
        Biome biome = container.getNoiseBiome((cp.x << 2) + 2, 16, (cp.z << 2) + 2);
        Theme theme = themeFor(biome);
        if (theme == Theme.NONE) return;

        // Mark before generation so a save/reload cannot carve the same chunk again.
        done.add(chunkKey(cp));

        Random random = new Random(((long) cp.x * 341873128712L)
                ^ ((long) cp.z * 132897987541L) ^ 0xA57A0CA7L);
        if (random.nextInt(3) == 0) return;

        int startX = cp.x << 4;
        int startZ = cp.z << 4;
        int centerX = startX + 5 + random.nextInt(7);
        int centerZ = startZ + 5 + random.nextInt(7);
        int centerY = 18 + random.nextInt(24);
        int radiusX = 5 + random.nextInt(3);
        int radiusY = 3 + random.nextInt(3);
        int radiusZ = 5 + random.nextInt(3);

        int minX = Math.max(startX, centerX - radiusX - 2);
        int maxX = Math.min(startX + 15, centerX + radiusX + 2);
        int minZ = Math.max(startZ, centerZ - radiusZ - 2);
        int maxZ = Math.min(startZ + 15, centerZ + radiusZ + 2);
        int minY = Math.max(2, centerY - radiusY - 2);
        int maxY = Math.min(250, centerY + radiusY + 2);

        // Carve the chamber and apply a theme-specific rock shell.
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    double dx = (x - centerX) / (double) radiusX;
                    double dy = (y - centerY) / (double) radiusY;
                    double dz = (z - centerZ) / (double) radiusZ;
                    double distance = dx * dx + dy * dy + dz * dz;
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState current = chunk.getBlockState(pos);
                    if (distance <= 1.0D) {
                        if (isCarvable(current)) {
                            chunk.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
                        }
                    } else if (distance <= 1.32D && isCarvable(current)) {
                        chunk.setBlockState(pos, shell(theme, random), false);
                    }
                }
            }
        }

        decorate(theme, chunk, startX, startZ, centerX, centerY, centerZ,
                radiusX, radiusY, radiusZ, minX, maxX, minZ, maxZ, random);
    }

    private static Theme themeFor(Biome biome) {
        if (biome == AstroWorldGenWorlds.FROZEN_PINE_VALLEY.get()) return Theme.ICE;
        if (biome == AstroWorldGenWorlds.VOLCANIC_BADLANDS.get()) return Theme.SULFUR;
        if (biome == AstroWorldGenWorlds.CRYSTAL_SPRINGS.get()) return Theme.CRYSTAL;
        if (biome == AstroWorldGenWorlds.CHERRY_GROVE.get()
                || biome == AstroWorldGenWorlds.PALE_FOREST.get()) return Theme.LUSH;
        return Theme.NONE;
    }

    private static boolean isCarvable(BlockState state) {
        return !state.isAir() && state.getFluidState().isEmpty()
                && state.getMaterial().blocksMovement() && state.getBlock() != Blocks.BEDROCK;
    }

    private static BlockState shell(Theme theme, Random random) {
        switch (theme) {
            case ICE:
                return random.nextInt(5) == 0 ? Blocks.BLUE_ICE.getDefaultState()
                        : Blocks.PACKED_ICE.getDefaultState();
            case SULFUR:
                return random.nextInt(4) == 0 ? ModBlocks.ASH_BLOCK.get().getDefaultState()
                        : random.nextBoolean() ? ModBlocks.SULFUR_STONE.get().getDefaultState()
                        : ModBlocks.VOLCANIC_ROCK.get().getDefaultState();
            case CRYSTAL:
                return random.nextInt(3) == 0 ? ModBlocks.FROST_CRYSTAL_BLOCK.get().getDefaultState()
                        : ModBlocks.CRYSTAL_BLOCK.get().getDefaultState();
            case LUSH:
                return random.nextInt(3) == 0 ? ModBlocks.ROOTED_CAVE_SOIL.get().getDefaultState()
                        : ModBlocks.LUSH_MOSS_BLOCK.get().getDefaultState();
            default:
                return Blocks.STONE.getDefaultState();
        }
    }

    private static void decorate(Theme theme, IChunk chunk, int startX, int startZ,
                                 int centerX, int centerY, int centerZ,
                                 int radiusX, int radiusY, int radiusZ,
                                 int minX, int maxX, int minZ, int maxZ, Random random) {
        for (int x = minX; x <= maxX; x++) {
            for (int y = Math.max(3, centerY - radiusY); y <= centerY + radiusY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    double dx = (x - centerX) / (double) radiusX;
                    double dy = (y - centerY) / (double) radiusY;
                    double dz = (z - centerZ) / (double) radiusZ;
                    if (dx * dx + dy * dy + dz * dz > 0.92D) continue;
                    BlockPos pos = new BlockPos(x, y, z);
                    if (!chunk.getBlockState(pos).isAir()) continue;

                    boolean ceiling = isSolid(chunk.getBlockState(pos.up()));
                    boolean floor = isSolid(chunk.getBlockState(pos.down()));
                    if (theme == Theme.ICE) {
                        if (ceiling && random.nextFloat() < 0.11F) {
                            chunk.setBlockState(pos, ModBlocks.ICICLE.get().getDefaultState(), false);
                        } else if (floor && random.nextFloat() < 0.035F) {
                            chunk.setBlockState(pos,
                                    ModBlocks.ICE_CRYSTAL.get().getDefaultState().with(IceCrystalBlock.FACING, Direction.UP), false);
                        } else if (ceiling && random.nextFloat() < 0.035F) {
                            chunk.setBlockState(pos,
                                    ModBlocks.ICE_CRYSTAL.get().getDefaultState().with(IceCrystalBlock.FACING, Direction.DOWN), false);
                        }
                    } else if (theme == Theme.LUSH && floor && random.nextFloat() < 0.045F) {
                        chunk.setBlockState(pos, ModBlocks.GLOWSHROOM_BLOCK.get().getDefaultState(), false);
                    } else if (theme == Theme.CRYSTAL && (floor || ceiling) && random.nextFloat() < 0.055F) {
                        Direction facing = floor ? Direction.UP : Direction.DOWN;
                        chunk.setBlockState(pos,
                                ModBlocks.ICE_CRYSTAL.get().getDefaultState().with(IceCrystalBlock.FACING, facing), false);
                    } else if (theme == Theme.SULFUR && floor && random.nextFloat() < 0.025F) {
                        chunk.setBlockState(pos, ModBlocks.EMBERSTONE.get().getDefaultState(), false);
                    }
                }
            }
        }

        if (theme == Theme.ICE) addFrozenPond(chunk, centerX, centerY - radiusY, centerZ, startX, startZ);
    }

    private static boolean isSolid(BlockState state) {
        return !state.isAir() && state.getFluidState().isEmpty() && state.getMaterial().blocksMovement();
    }

    private static void addFrozenPond(IChunk chunk, int centerX, int floorY, int centerZ, int startX, int startZ) {
        int minX = Math.max(startX, centerX - 2);
        int maxX = Math.min(startX + 15, centerX + 2);
        int minZ = Math.max(startZ, centerZ - 2);
        int maxZ = Math.min(startZ + 15, centerZ + 2);
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                int dx = x - centerX;
                int dz = z - centerZ;
                if (dx * dx + dz * dz > 5) continue;
                BlockPos surface = new BlockPos(x, floorY, z);
                BlockPos below = surface.down();
                if (chunk.getBlockState(surface).isAir() && isSolid(chunk.getBlockState(below))) {
                    chunk.setBlockState(below, Blocks.WATER.getDefaultState(), false);
                    chunk.setBlockState(surface, ModBlocks.BRITTLE_ICE.get().getDefaultState(), false);
                }
            }
        }
    }

    private enum Theme {
        NONE, ICE, SULFUR, CRYSTAL, LUSH
    }
}
