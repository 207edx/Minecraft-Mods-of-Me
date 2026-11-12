package com.astro.astroworldgen.registry;

import com.astro.astroworldgen.AstroWorldGen;
import com.astro.astroworldgen.entity.PenguinEntity;
import com.astro.astroworldgen.worldgen.AstroWorldGenWorlds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/** Entity registry and spawn integration for AstroWorldGen. */
public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, AstroWorldGen.MOD_ID);

    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITIES.register("penguin",
            () -> EntityType.Builder.<PenguinEntity>create(PenguinEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 0.9F).build(AstroWorldGen.MOD_ID + ":penguin"));

    public static void setup(FMLCommonSetupEvent event) {
        // Forge 32.0.108 uses DeferredWorkQueue; enqueueWork is from later Forge releases.
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PENGUIN.get(), ModAttrs.make(10.0D, 0.22D).create());

            EntitySpawnPlacementRegistry.register(PENGUIN.get(),
                    EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    (type, world, reason, pos, random) ->
                            canSpawnOnColdGround(world.getBlockState(pos.down()).getBlock()));

            for (Biome biome : ForgeRegistries.BIOMES) {
                if (biome.getCategory() == Biome.Category.ICY) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(PENGUIN.get(), 10, 2, 5));
                }
            }
            AstroWorldGenWorlds.FROZEN_PINE_VALLEY.get().getSpawns(EntityClassification.CREATURE)
                    .add(new Biome.SpawnListEntry(PENGUIN.get(), 12, 2, 5));
        });
    }

    private static boolean canSpawnOnColdGround(Block block) {
        return block == Blocks.SNOW_BLOCK || block == Blocks.SNOW
                || block == Blocks.ICE || block == Blocks.PACKED_ICE || block == Blocks.BLUE_ICE
                || block == Blocks.FROSTED_ICE;
    }

    private ModEntities() {
    }
}
