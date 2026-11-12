package com.astro.astroworldgen.worldgen;

import com.astro.astroworldgen.AstroWorldGen;
import com.astro.astroworldgen.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
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
 * Custom biomes and safe, generation-time cave/deposit integration for Forge 32.
 * No terrain is edited from chunk-load events: saved chunks stay untouched.
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
        // Forge 32.0.108 uses DeferredWorkQueue instead of the later enqueueWork API.
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

            // Apply the added cave network and geology to normal Overworld generation.
            // Carvers and features run only while a chunk is first generated.
            for (Biome biome : ForgeRegistries.BIOMES) {
                if (biome.getCategory() == Biome.Category.NETHER) {
                    addNetherDeposits(biome);
                    continue;
                }
                if (biome.getCategory() == Biome.Category.THEEND) continue;

                biome.addCarver(GenerationStage.Carving.AIR,
                        Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.16F)));
                biome.addCarver(GenerationStage.Carving.AIR,
                        Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.018F)));

                addOverworldDeposits(biome);
            }
        });
    }

    private static void add(Biome biome, BiomeManager.BiomeType climate, int weight,
                            BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(climate, new BiomeManager.BiomeEntry(biome, weight));
    }

    private static void addOverworldDeposits(Biome biome) {
        addOre(biome, ModBlocks.DEEPSLATE_IRON_ORE.get(),
                OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 5, 4, 48);
        addOre(biome, ModBlocks.FOSSIL_STONE.get(),
                OreFeatureConfig.FillerBlockType.NATURAL_STONE, 6, 2, 5, 28);
        addOre(biome, ModBlocks.CRYSTAL_BLOCK.get(),
                OreFeatureConfig.FillerBlockType.NATURAL_STONE, 5, 2, 8, 52);

        if (biome == FROZEN_PINE_VALLEY.get()) {
            addOre(biome, ModBlocks.FROSTSTONE.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 8, 5, 8, 55);
            addOre(biome, ModBlocks.FROST_CRYSTAL_BLOCK.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 4, 2, 10, 46);
        } else if (biome == VOLCANIC_BADLANDS.get()) {
            addOre(biome, ModBlocks.SULFUR_ORE.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 4, 8, 55);
            addOre(biome, ModBlocks.VOLCANIC_ROCK.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 10, 3, 5, 38);
            addOre(biome, ModBlocks.ASH_BLOCK.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 6, 2, 8, 34);
        }

        if (biome.getDownfall() >= 0.55F || biome.getCategory() == Biome.Category.FOREST) {
            addOre(biome, ModBlocks.LUSH_MOSS_BLOCK.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 9, 5, 10, 58);
            addOre(biome, ModBlocks.ROOTED_CAVE_SOIL.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 3, 12, 50);
            addOre(biome, ModBlocks.GLOWSHROOM_BLOCK.get(),
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, 4, 2, 10, 42);
        }
    }

    private static void addNetherDeposits(Biome biome) {
        addOre(biome, ModBlocks.CALDERA_ROCK.get(),
                OreFeatureConfig.FillerBlockType.NETHERRACK, 10, 5, 8, 120);
        addOre(biome, ModBlocks.ASH_BLOCK.get(),
                OreFeatureConfig.FillerBlockType.NETHERRACK, 8, 4, 8, 118);
        addOre(biome, ModBlocks.EMBERSTONE.get(),
                OreFeatureConfig.FillerBlockType.NETHERRACK, 5, 2, 12, 110);
        addOre(biome, ModBlocks.SOULGLASS.get(),
                OreFeatureConfig.FillerBlockType.NETHERRACK, 4, 2, 10, 96);
    }

    private static void addOre(Biome biome, Block block, OreFeatureConfig.FillerBlockType filler,
                               int size, int count, int minY, int maxY) {
        ConfiguredFeature<?, ?> feature = Feature.ORE
                .withConfiguration(new OreFeatureConfig(filler, block.getDefaultState(), size))
                .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, minY, 0, maxY)));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
    }

    private static final class AstroBiome extends Biome {
        private AstroBiome(Biome.Builder builder) {
            super(builder);
        }
    }

    private AstroWorldGenWorlds() {
    }
}
