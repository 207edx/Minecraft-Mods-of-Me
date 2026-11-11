package com.astro.astroworldgen.registry;

import com.astro.astroworldgen.AstroWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

/** Block items and first-wave resource items. */
public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AstroWorldGen.MOD_ID);

    public static final RegistryObject<Item> DEEPSLATE = blockItem("deepslate", ModBlocks.DEEPSLATE);
    public static final RegistryObject<Item> COBBLED_DEEPSLATE = blockItem("cobbled_deepslate", ModBlocks.COBBLED_DEEPSLATE);
    public static final RegistryObject<Item> POLISHED_DEEPSLATE = blockItem("polished_deepslate", ModBlocks.POLISHED_DEEPSLATE);
    public static final RegistryObject<Item> DEEPSLATE_BRICKS = blockItem("deepslate_bricks", ModBlocks.DEEPSLATE_BRICKS);
    public static final RegistryObject<Item> DEEPSLATE_IRON_ORE = blockItem("deepslate_iron_ore", ModBlocks.DEEPSLATE_IRON_ORE);
    public static final RegistryObject<Item> LUSH_MOSS_BLOCK = blockItem("lush_moss_block", ModBlocks.LUSH_MOSS_BLOCK);
    public static final RegistryObject<Item> ROOTED_CAVE_SOIL = blockItem("rooted_cave_soil", ModBlocks.ROOTED_CAVE_SOIL);
    public static final RegistryObject<Item> GLOWSHROOM_BLOCK = blockItem("glowshroom_block", ModBlocks.GLOWSHROOM_BLOCK);
    public static final RegistryObject<Item> FROSTSTONE = blockItem("froststone", ModBlocks.FROSTSTONE);
    public static final RegistryObject<Item> FROSTSTONE_BRICKS = blockItem("froststone_bricks", ModBlocks.FROSTSTONE_BRICKS);
    public static final RegistryObject<Item> SNOW_BRICKS = blockItem("snow_bricks", ModBlocks.SNOW_BRICKS);
    public static final RegistryObject<Item> FROST_CRYSTAL_BLOCK = blockItem("frost_crystal_block", ModBlocks.FROST_CRYSTAL_BLOCK);
    public static final RegistryObject<Item> SULFUR_ORE = blockItem("sulfur_ore", ModBlocks.SULFUR_ORE);
    public static final RegistryObject<Item> SULFUR_STONE = blockItem("sulfur_stone", ModBlocks.SULFUR_STONE);
    public static final RegistryObject<Item> SULFUR_STONE_BRICKS = blockItem("sulfur_stone_bricks", ModBlocks.SULFUR_STONE_BRICKS);
    public static final RegistryObject<Item> SULFUR_BLOCK = blockItem("sulfur_block", ModBlocks.SULFUR_BLOCK);
    public static final RegistryObject<Item> VOLCANIC_ROCK = blockItem("volcanic_rock", ModBlocks.VOLCANIC_ROCK);
    public static final RegistryObject<Item> VOLCANIC_BRICKS = blockItem("volcanic_bricks", ModBlocks.VOLCANIC_BRICKS);
    public static final RegistryObject<Item> ASH_BLOCK = blockItem("ash_block", ModBlocks.ASH_BLOCK);
    public static final RegistryObject<Item> ASHSTONE_BRICKS = blockItem("ashstone_bricks", ModBlocks.ASHSTONE_BRICKS);
    public static final RegistryObject<Item> EMBERSTONE = blockItem("emberstone", ModBlocks.EMBERSTONE);
    public static final RegistryObject<Item> CRYSTAL_BLOCK = blockItem("crystal_block", ModBlocks.CRYSTAL_BLOCK);
    public static final RegistryObject<Item> ALIEN_SOIL = blockItem("alien_soil", ModBlocks.ALIEN_SOIL);
    public static final RegistryObject<Item> DEADWOOD_PLANKS = blockItem("deadwood_planks", ModBlocks.DEADWOOD_PLANKS);
    public static final RegistryObject<Item> LILAC_STONE = blockItem("lilac_stone", ModBlocks.LILAC_STONE);
    public static final RegistryObject<Item> LILAC_STONE_BRICKS = blockItem("lilac_stone_bricks", ModBlocks.LILAC_STONE_BRICKS);
    public static final RegistryObject<Item> END_SHARD_ORE = blockItem("end_shard_ore", ModBlocks.END_SHARD_ORE);
    public static final RegistryObject<Item> CALDERA_ROCK = blockItem("caldera_rock", ModBlocks.CALDERA_ROCK);
    public static final RegistryObject<Item> SOULGLASS = blockItem("soulglass", ModBlocks.SOULGLASS);
    public static final RegistryObject<Item> EMBERWOOD_PLANKS = blockItem("emberwood_planks", ModBlocks.EMBERWOOD_PLANKS);
    public static final RegistryObject<Item> CRIMSON_MIRE_BRICKS = blockItem("crimson_mire_bricks", ModBlocks.CRIMSON_MIRE_BRICKS);
    public static final RegistryObject<Item> FOSSIL_STONE = blockItem("fossil_stone", ModBlocks.FOSSIL_STONE);

    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> FROST_CRYSTAL = ITEMS.register("frost_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> EMBER_FRAGMENT = ITEMS.register("ember_fragment",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> END_SHARD = ITEMS.register("end_shard",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    private static RegistryObject<Item> blockItem(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    }

    private ModItems() {
    }
}
