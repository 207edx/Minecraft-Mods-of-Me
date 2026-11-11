package com.astro.astroworldgen.registry;

import com.astro.astroworldgen.AstroWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

/**
 * First registered material batch for AstroWorldGen.
 * These are placeable base blocks. Natural biome placement and extra shapes
 * are tracked separately and are not implied by registration.
 */
public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AstroWorldGen.MOD_ID);

    public static final RegistryObject<Block> DEEPSLATE = registerRock("deepslate", 3.5F, 6F, 0);
    public static final RegistryObject<Block> COBBLED_DEEPSLATE = registerRock("cobbled_deepslate", 3.5F, 6F, 0);
    public static final RegistryObject<Block> POLISHED_DEEPSLATE = registerRock("polished_deepslate", 3.5F, 6F, 0);
    public static final RegistryObject<Block> DEEPSLATE_BRICKS = registerRock("deepslate_bricks", 3.5F, 6F, 0);
    public static final RegistryObject<Block> DEEPSLATE_IRON_ORE = registerRock("deepslate_iron_ore", 4F, 6F, 1);
    public static final RegistryObject<Block> LUSH_MOSS_BLOCK = registerRock("lush_moss_block", 0.6F, 0.6F, 0);
    public static final RegistryObject<Block> ROOTED_CAVE_SOIL = registerRock("rooted_cave_soil", 0.5F, 0.5F, 0);
    public static final RegistryObject<Block> GLOWSHROOM_BLOCK = registerRock("glowshroom_block", 0.2F, 0.2F, 0);
    public static final RegistryObject<Block> FROSTSTONE = registerRock("froststone", 1.5F, 3F, 0);
    public static final RegistryObject<Block> FROSTSTONE_BRICKS = registerRock("froststone_bricks", 1.5F, 3F, 0);
    public static final RegistryObject<Block> SNOW_BRICKS = registerRock("snow_bricks", 0.8F, 0.8F, 0);
    public static final RegistryObject<Block> FROST_CRYSTAL_BLOCK = registerRock("frost_crystal_block", 2F, 3F, 0);
    public static final RegistryObject<Block> SULFUR_ORE = registerRock("sulfur_ore", 4F, 6F, 1);
    public static final RegistryObject<Block> SULFUR_STONE = registerRock("sulfur_stone", 2F, 4F, 0);
    public static final RegistryObject<Block> SULFUR_STONE_BRICKS = registerRock("sulfur_stone_bricks", 2F, 4F, 0);
    public static final RegistryObject<Block> SULFUR_BLOCK = registerRock("sulfur_block", 2F, 4F, 0);
    public static final RegistryObject<Block> VOLCANIC_ROCK = registerRock("volcanic_rock", 2F, 6F, 0);
    public static final RegistryObject<Block> VOLCANIC_BRICKS = registerRock("volcanic_bricks", 2F, 6F, 0);
    public static final RegistryObject<Block> ASH_BLOCK = registerRock("ash_block", 0.8F, 1F, 0);
    public static final RegistryObject<Block> ASHSTONE_BRICKS = registerRock("ashstone_bricks", 2F, 6F, 0);
    public static final RegistryObject<Block> EMBERSTONE = registerRock("emberstone", 2F, 6F, 0);
    public static final RegistryObject<Block> CRYSTAL_BLOCK = registerRock("crystal_block", 2F, 3F, 0);
    public static final RegistryObject<Block> ALIEN_SOIL = registerRock("alien_soil", 1.5F, 9F, 0);
    public static final RegistryObject<Block> DEADWOOD_PLANKS = registerRock("deadwood_planks", 2F, 3F, 0);
    public static final RegistryObject<Block> LILAC_STONE = registerRock("lilac_stone", 1.5F, 6F, 0);
    public static final RegistryObject<Block> LILAC_STONE_BRICKS = registerRock("lilac_stone_bricks", 1.5F, 6F, 0);
    public static final RegistryObject<Block> END_SHARD_ORE = registerRock("end_shard_ore", 4F, 9F, 2);
    public static final RegistryObject<Block> CALDERA_ROCK = registerRock("caldera_rock", 2F, 6F, 0);
    public static final RegistryObject<Block> SOULGLASS = registerRock("soulglass", 0.8F, 0.8F, 0);
    public static final RegistryObject<Block> EMBERWOOD_PLANKS = registerRock("emberwood_planks", 2F, 3F, 0);
    public static final RegistryObject<Block> CRIMSON_MIRE_BRICKS = registerRock("crimson_mire_bricks", 2F, 6F, 0);
    public static final RegistryObject<Block> FOSSIL_STONE = registerRock("fossil_stone", 2F, 4F, 0);

    private static RegistryObject<Block> registerRock(String name, float hardness, float resistance, int harvestLevel) {
        return BLOCKS.register(name, () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(harvestLevel)));
    }

    private ModBlocks() {
    }
}
