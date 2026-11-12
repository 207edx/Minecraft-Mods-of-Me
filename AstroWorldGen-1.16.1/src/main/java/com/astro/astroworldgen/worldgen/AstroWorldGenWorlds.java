package com.astro.astroworldgen.worldgen;

import com.astro.astroworldgen.AstroWorldGen;
import com.astro.astroworldgen.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Legacy 1.16.1 world-generation path. Cave themes use legacy carvers and
 * biome-attached deposits because separate underground biome volumes were
 * introduced in later Minecraft versions.
 */
public final class AstroWorldGenWorlds {
    private static final Logger LOGGER = LogManager.getLogger();
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

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        BIOMES.register(bus);
    }

    private static Biome makeBiome(Biome.Category category, float depth, float scale,
                                   float temperature, float downfall, Biome.RainType rain,
                                   int waterColor, int waterFogColor,
                                   Block top, Block filler, Block foundation) {
        return new Biome.Builder()
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                        top.getDefaultState(), filler.getDefaultState(), foundation.getDefaultState()))
                .precipitation(rain)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .mobSpawnSettings(new MobSpawnInfo.Builder().build())
                .generationSettings(new BiomeGenerationSettings.Builder().build())
                .parent((String) null)
                .build();
    }

    public static void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addBiome(CHERRY_GROVE.get(), BiomeManager.BiomeType.WARM, 7,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
            addBiome(PALE_FOREST.get(), BiomeManager.BiomeType.COOL, 5,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DEAD);
            addBiome(FROZEN_PINE_VALLEY.get(), BiomeManager.BiomeType.ICY, 6,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
            addBiome(VOLCANIC_BADLANDS.get(), BiomeManager.BiomeType.WARM, 4,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY);
            addBiome(CRYSTAL_SPRINGS.get(), BiomeManager.BiomeType.COOL, 5,
                    BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);

            addFeature(CHERRY_GROVE.get(), GenerationStage.Decoration.VEGETAL_DECORATION, Features.FANCY_OAK);
            addFeature(PALE_FOREST.get(), GenerationStage.Decoration.VEGETAL_DECORATION, Features.FANCY_OAK);
            addFeature(CRYSTAL_SPRINGS.get(), GenerationStage.Decoration.VEGETAL_DECORATION, Features.FANCY_OAK);

            addCaveCarver(CHERRY_GROVE.get());
            addCaveCarver(PALE_FOREST.get());
            addCaveCarver(FROZEN_PINE_VALLEY.get());
            addCaveCarver(VOLCANIC_BADLANDS.get());
            addCaveCarver(CRYSTAL_SPRINGS.get());

            Set<Biome> visited = new HashSet<>();
            int overworld = 0;
            int nether = 0;
            for (Biome biome : ForgeRegistries.BIOMES) {
                if (!visited.add(biome)) continue;
                if (biome.getCategory() == Biome.Category.NETHER) {
                    addNetherDeposits(biome);
                    nether++;
                } else if (biome.getCategory() != Biome.Category.THEEND) {
                    addOverworldDeposits(biome);
                    overworld++;
                }
            }
            LOGGER.info("AstroWorldGen added themed deposits to {} Overworld biomes and {} Nether biomes.", overworld, nether);
        });
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType climate, int weight,
                                 BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(
                ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name missing"));
        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(climate, new BiomeManager.BiomeEntry(key, weight));
    }

    private static void addOverworldDeposits(Biome biome) {
        addOre(biome, ModBlocks.DEEPSLATE_IRON_ORE.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 8, 4, 42);
        addOre(biome, ModBlocks.FOSSIL_STONE.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 6, 2, 5, 25);
        addOre(biome, ModBlocks.CRYSTAL_BLOCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 5, 2, 8, 52);

        if (biome.getTemperature() <= 0.30F) {
            addOre(biome, ModBlocks.FROSTSTONE.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 8, 5, 8, 55);
            addOre(biome, ModBlocks.FROST_CRYSTAL_BLOCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 4, 2, 10, 46);
        } else if (biome.getTemperature() >= 0.90F) {
            addOre(biome, ModBlocks.SULFUR_ORE.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 4, 8, 55);
            addOre(biome, ModBlocks.VOLCANIC_ROCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 10, 3, 5, 38);
            addOre(biome, ModBlocks.ASH_BLOCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 6, 2, 8, 34);
        }

        if (biome.getDownfall() >= 0.55F || biome.getCategory() == Biome.Category.FOREST
                || biome.getCategory() == Biome.Category.SWAMP) {
            addOre(biome, ModBlocks.LUSH_MOSS_BLOCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 9, 5, 10, 58);
            addOre(biome, ModBlocks.ROOTED_CAVE_SOIL.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 7, 3, 12, 50);
            addOre(biome, ModBlocks.GLOWSHROOM_BLOCK.get(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, 4, 2, 10, 42);
        }
    }

    private static void addNetherDeposits(Biome biome) {
        addOre(biome, ModBlocks.CALDERA_ROCK.get(), OreFeatureConfig.FillerBlockType.NETHERRACK, 10, 5, 8, 120);
        addOre(biome, ModBlocks.ASH_BLOCK.get(), OreFeatureConfig.FillerBlockType.NETHERRACK, 8, 4, 8, 118);
        addOre(biome, ModBlocks.EMBERSTONE.get(), OreFeatureConfig.FillerBlockType.NETHERRACK, 5, 2, 12, 110);
        addOre(biome, ModBlocks.SOULGLASS.get(), OreFeatureConfig.FillerBlockType.NETHERRACK, 4, 2, 10, 96);
    }

    private static void addOre(Biome biome, Block block, OreFeatureConfig.FillerBlockType filler,
                               int size, int count, int minY, int maxY) {
        ConfiguredFeature<?, ?> feature = Feature.ORE
                .withConfiguration(new OreFeatureConfig(filler, block.getDefaultState(), size))
                .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, minY, 0, maxY)));
        addFeature(biome, GenerationStage.Decoration.UNDERGROUND_ORES, feature);
    }

    private static void addFeature(Biome biome, GenerationStage.Decoration stage, ConfiguredFeature<?, ?> feature) {
        try {
            BiomeGenerationSettings settings = biome.func_242440_e();
            List<List<Supplier<ConfiguredFeature<?, ?>>>> original =
                    ObfuscationReflectionHelper.getPrivateValue(BiomeGenerationSettings.class, settings, "field_242484_f");
            List<List<Supplier<ConfiguredFeature<?, ?>>>> updated = new ArrayList<>(original);
            while (updated.size() <= stage.ordinal()) updated.add(new ArrayList<>());
            List<Supplier<ConfiguredFeature<?, ?>>> entries = new ArrayList<>(updated.get(stage.ordinal()));
            entries.add(() -> feature);
            updated.set(stage.ordinal(), entries);
            ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, settings, updated, "field_242484_f");
        } catch (RuntimeException error) {
            LOGGER.error("Unable to add feature {} to biome {}", feature, biome.getRegistryName(), error);
        }
    }

    private static void addCaveCarver(Biome biome) {
        try {
            BiomeGenerationSettings settings = biome.func_242440_e();
            Map<GenerationStage.Carving, List<Supplier<ConfiguredCarver<?>>>> original =
                    ObfuscationReflectionHelper.getPrivateValue(BiomeGenerationSettings.class, settings, "field_242483_e");
            Map<GenerationStage.Carving, List<Supplier<ConfiguredCarver<?>>>> updated =
                    new EnumMap<>(GenerationStage.Carving.class);
            updated.putAll(original);
            List<Supplier<ConfiguredCarver<?>>> air =
                    new ArrayList<>(updated.getOrDefault(GenerationStage.Carving.AIR, new ArrayList<>()));
            air.add(() -> ConfiguredCarvers.CAVE);
            updated.put(GenerationStage.Carving.AIR, air);
            ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, settings, updated, "field_242483_e");
        } catch (RuntimeException error) {
            LOGGER.error("Unable to add legacy cave carving to biome {}", biome.getRegistryName(), error);
        }
    }

    private AstroWorldGenWorlds() {
    }
}