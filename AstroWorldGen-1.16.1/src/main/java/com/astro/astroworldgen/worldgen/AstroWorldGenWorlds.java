package com.astro.astroworldgen.worldgen;

import com.astro.astroworldgen.AstroWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Custom Overworld biomes using the original Forge 32 / Minecraft 1.16.1 API.
 * In this version a Biome is constructed by subclassing Biome and passing its
 * Builder to super; the later Builder.build() method is not available.
 */
public final class AstroWorldGenWorlds {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, AstroWorldGen.MOD_ID);

    public static final RegistryObject<Biome> CHERRY_GROVE = BIOMES.register("cherry_grove",
            () -> makeBiome(Biome.Category.FOREST, 0.12F, 0.22F, 0.72F, 0.82F,
                    Biome.RainType.RAIN, 0xD98FB9, 0xB77EA0,
                    Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));

    public static final RegistryObject<Biome> PALE_FOREST = BIOMES.register("pale_forest",
            () -> makeBiome(Biome.Category.FOREST, 0.18F, 0.16F, 0.48F, 0.35F,
                    Biome.RainType.RAIN, 0xB8B8C3, 0x81818F,
                    Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.STONE));

    public static final RegistryObject<Biome> FROZEN_PINE_VALLEY = BIOMES.register("frozen_pine_valley",
            () -> makeBiome(Biome.Category.TAIGA, 0.18F, 0.08F, -0.35F, 0.55F,
                    Biome.RainType.SNOW, 0x9BCBE7, 0x668BAA,
                    Blocks.SNOW_BLOCK, Blocks.DIRT, Blocks.STONE));

    public static final RegistryObject<Biome> VOLCANIC_BADLANDS = BIOMES.register("volcanic_badlands",
            () -> makeBiome(Biome.Category.MESA, 0.22F, 0.24F, 1.45F, 0.05F,
                    Biome.RainType.NONE, 0x9B665C, 0x5D3938,
                    Blocks.BLACKSTONE, Blocks.BASALT, Blocks.STONE));

    public static final RegistryObject<Biome> CRYSTAL_SPRINGS = BIOMES.register("crystal_springs",
            () -> makeBiome(Biome.Category.FOREST, 0.08F, 0.12F, 0.64F, 0.90F,
                    Biome.RainType.RAIN, 0x65C7CC, 0x39868D,
                    Blocks.GRASS_BLOCK, Blocks.CLAY, Blocks.STONE));

    private static Biome makeBiome(Biome.Category category, float depth, float scale,
                                   float temperature, float downfall, Biome.RainType precipitation,
                                   int waterColor, int waterFogColor,
                                   Block top, Block filler, Block under) {
        Biome.Builder builder = new Biome.Builder()
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(top.getDefaultState(), filler.getDefaultState(), under.getDefaultState()))
                .precipitation(precipitation)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .func_235097_a_(new BiomeAmbience.Builder()
                        .setWaterColor(waterColor)
                        .setWaterFogColor(waterFogColor)
                        .setFogColor(0xC8D8E8)
                        .setMoodSound(MoodSoundAmbience.field_235027_b_)
                        .build())
                .parent((String) null);
        return new AstroBiome(builder);
    }

    public static void register(IEventBus modBus) {
        BIOMES.register(modBus);
    }

    public static void setup(FMLCommonSetupEvent event) {
        // Forge 32.0.108 uses DeferredWorkQueue; enqueueWork is from later Forge releases.
        DeferredWorkQueue.runLater(() -> {
            add(CHERRY_GROVE.get(), BiomeManager.BiomeType.WARM, 7,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
            add(PALE_FOREST.get(), BiomeManager.BiomeType.COOL, 5,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST);
            add(FROZEN_PINE_VALLEY.get(), BiomeManager.BiomeType.ICY, 6,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
            add(VOLCANIC_BADLANDS.get(), BiomeManager.BiomeType.WARM, 4,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);
            add(CRYSTAL_SPRINGS.get(), BiomeManager.BiomeType.COOL, 5,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
        });
    }

    private static void add(Biome biome, BiomeManager.BiomeType climate, int weight,
                            BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(climate, new BiomeManager.BiomeEntry(biome, weight));
    }

    private static final class AstroBiome extends Biome {
        private AstroBiome(Biome.Builder builder) {
            super(builder);
        }
    }

    private AstroWorldGenWorlds() {
    }
}
