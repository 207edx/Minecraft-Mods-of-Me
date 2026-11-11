# AstroWorldGen — Blocks, Materials and Variants Catalogue

**Purpose:** One place for every planned natural block, building material, ore, decorative set and functional world block in AstroWorldGen.

> This catalogue mixes an initial source-registered prototype batch with planned designs. The source-registered batch is listed below; all other entries remain planned until code and in-game verification are recorded. Exact hardness, harvest tools, light levels, sounds and drops still require testing.

## 0. First source-registered batch

The current source tree registers the following **32 base blocks** as placeable block items. Their natural world generation is not yet implemented.

| Family | Registered base blocks |
|---|---|
| Deepslate | deepslate, cobbled_deepslate, polished_deepslate, deepslate_bricks, deepslate_iron_ore |
| Lush caves | lush_moss_block, rooted_cave_soil, glowshroom_block |
| Ice/winter | froststone, froststone_bricks, snow_bricks, frost_crystal_block |
| Sulfur | sulfur_ore, sulfur_stone, sulfur_stone_bricks, sulfur_block |
| Volcanic/lava caves | volcanic_rock, volcanic_bricks, ash_block, ashstone_bricks, emberstone |
| Crystal | crystal_block |
| End | alien_soil, deadwood_planks, lilac_stone, lilac_stone_bricks, end_shard_ore |
| Nether | caldera_rock, soulglass, emberwood_planks, crimson_mire_bricks |
| Fossil | fossil_stone |

Six resource items are registered: sulfur, frost_crystal, crystal_shard, ember_fragment, ash and end_shard.

**Prototype limitations:** the first block batch uses simple full-cube block classes. Its JSON models currently reference existing vanilla textures as temporary placeholders. Specialized block shapes, custom textures, correct ore Fortune/Silk Touch behavior, ambient effects, block entities and natural placement are not yet implemented. The wood-themed plank blocks still need final material/tool-property review before release.


## 1. Block-family rules

For each suitable solid building material, consider a consistent family:

- Base block.
- Polished or smooth block where the material supports it.
- Bricks.
- Cracked bricks.
- Chiseled/decorative block.
- Pillar or column.
- Stairs, slabs and walls.
- Matching item models, blockstates, loot tables and localization.

Not every material needs every variant. Natural plants, ores, fluids, fragile crystals and functional blocks should not receive nonsensical stairs/walls just to complete a set.

Wood families should use the normal Minecraft building forms where appropriate:

- Log, stripped log, wood, stripped wood and planks.
- Stairs and slabs.
- Fence and fence gate.
- Door and trapdoor.
- Pressure plate and button.
- Sign and hanging/decorative sign where supported by the 1.16.1 implementation.
- Sapling/seed, leaves and natural growth feature.

## 2. Overworld stone and geological blocks

### 2.1 Deepslate family

Working IDs:
- `deepslate`
- `cobbled_deepslate`
- `polished_deepslate`
- `deepslate_bricks`
- `cracked_deepslate_bricks`
- `deepslate_tiles`
- `cracked_deepslate_tiles`
- `chiseled_deepslate`
- `deepslate_pillar`

Building variants:
- Deepslate stairs, slabs and walls.
- Cobbled deepslate stairs, slabs and walls.
- Polished deepslate stairs, slabs and walls.
- Deepslate brick stairs, slabs and walls.
- Deepslate tile stairs, slabs and walls.

Ore variants:
- Deepslate iron, gold, redstone, lapis, diamond and emerald ore.
- Deepslate copper ore if the custom copper material is enabled.
- Ore drops must match the normal ore's fortune/silk-touch rules unless there is a deliberate documented difference.

Natural placement:
- Deeper stone bands and large underground regions.
- Deep Stone Halls, Fossil Chambers and selected cave floors/walls.
- Deepslate should blend between stone layers instead of appearing as an arbitrary flat stripe.

### 2.2 Additional geological sets

| Material | Natural blocks | Crafted/decorative variants | Main locations |
|---|---|---|---|
| Limestone | limestone, smooth_limestone | limestone_bricks, cracked_limestone_bricks, chiseled_limestone, pillar, stairs, slab, wall | Lush caves, springs, wet underground regions |
| Marble | marble, polished_marble | marble_bricks, chiseled_marble, pillar, stairs, slab, wall | Crystal Caverns and rare mountain veins |
| Slate | slate, cobbled_slate | polished_slate, slate_bricks, slate_tiles, stairs, slab, wall | Deep caves and mountain layers |
| Volcanic tuff | volcanic_tuff, rough_volcanic_rock | polished_volcanic_rock, volcanic_bricks, cracked volcanic bricks, stairs, slab, wall | Lava Caves, volcanic Overworld regions |
| Froststone | froststone, packed_froststone | polished_froststone, froststone_bricks, chiseled_froststone, stairs, slab, wall | Ice Caves and glacial underground pockets |
| Sulfur stone | sulfur_stone, sulfur_crust | cut_sulfur_stone, sulfur_bricks, chiseled_sulfur_stone, stairs, slab, wall | Sulfur Caves |
| Fossil stone | fossil_stone, bone_fossil_block | fossil_bricks, chiseled_fossil, fossil_tiles, stairs, slab, wall | Rare Fossil Chambers |

## 3. Lush Cave blocks and plants

### Natural terrain and ground cover
- `lush_cave_moss`: dense moss block for floors and walls.
- `lush_moss_carpet`: thin moss ground cover.
- `rooted_cave_soil`: damp soil used around roots and underground trees.
- `hanging_roots`: ceiling-hanging decorative plant.
- `cave_vines`: climbable or decorative hanging vegetation; any glow/fruit mechanic is a separate feature.
- `glowmoss`: low-light ground/wall growth.
- `glowshroom_block`: mushroom cap/cluster block.
- `glowshroom_stem`: stem block.
- `cave_leaf_block`: dense underground foliage.
- `cave_flower`: small decorative plant.
- `cave_bloom`: larger rare flower.
- `spore_pod`: decorative hanging growth; particle behavior only after performance tests.

### Lush building variants
- Mossy limestone, mossy slate and mossy deepslate.
- Mossy bricks, mossy brick stairs, slabs and walls.
- Rooted stone and overgrown stone variants.
- Glowshroom planks and stem boards only if a harvestable wood-like tree is designed; do not turn every mushroom into normal wood automatically.

### Generation
- Moss carpets and patches across damp cave floors.
- Hanging roots under natural overhangs.
- Glowshroom groves near water and rooted cave soil.
- Rare lush grottos with an underground tree, pool and flower clusters.

## 4. Ice, snow and Ice Spikes blocks

### Ice blocks
- `frost_ice`: custom stable ice; does not vanish merely because the player looks away.
- `packed_frost_ice`: dense cold-region ice.
- `blue_frost_ice`: rare blue ice-like material with a defined movement property.
- `frosted_ice_bricks`, `chiseled_frost_ice`, `ice_pillar`.
- Ice brick stairs, slabs and walls where useful.
- `cracked_ice` and `thin_ice`: special fragile variants with clearly defined support and break rules.
- `frost_crystal_block` and `frost_crystal_cluster`: decorative/resource blocks.

### Snow blocks
- `snow_bricks`, `snow_brick_stairs`, `snow_brick_slab`, `snow_brick_wall`.
- `carved_snow`, `compacted_snow`, `snow_pillar`.
- Snow brick blocks should follow a deliberate melting rule; the intended default is non-melting building material.

### Ice Spike generation
Ice Spikes are a **world-generation feature made from ice blocks**, not necessarily one giant block. Planned shapes:
- Tall thin spikes.
- Broad clustered spires.
- Broken/fallen ice columns.
- Buried ice roots and underground spike formations.
- Rare giant spike fields in frozen biomes.

### Icicles and crystals
- `icicle`: hanging natural block; falling/damage behavior must be readable and configurable.
- `frost_crystal`: small natural cluster.
- `frost_crystal_block`: crafted decorative storage block.
- `ice_lantern`: optional crafted light block, with light level and recipe balance to be tested.

## 5. Sulfur Cave blocks

- `sulfur_ore`: ore block that drops sulfur material.
- `deepslate_sulfur_ore`: deep variant.
- `raw_sulfur_block`: compact storage block.
- `sulfur_block`: refined decorative/storage block if refining is useful.
- `sulfur_stone` and `sulfur_crust`: natural cave surfaces.
- `sulfur_crystals`: small and large deposit variants.
- `sulfur_vent`: natural feature block that periodically emits steam particles/sound.
- `sealed_sulfur_vent`: optional player-crafted decorative vent cover.
- `mineral_spring_block`: source for a warm/mineral pool only if fluid behavior is implemented safely.

Sulfur vents are world features and should not be craftable by default. Any gameplay effect must have clear warning and configuration.

## 6. Lava Cave and volcanic blocks

- `volcanic_rock`, `cooled_volcanic_rock`, `volcanic_tuff`.
- `ash_block` and `compacted_ash`.
- `emberstone` and `emberstone_bricks`.
- `magma_crust`: natural crust around hot areas.
- `obsidian_bricks`, `polished_obsidian`, `chiseled_obsidian`, obsidian stairs/slabs/walls.
- `basalt_bricks`, `polished_basalt`, basalt pillar and matching forms where the base game's material set does not already provide them.
- `ember_crystal` and `ember_crystal_block`.
- `lava_glass`: decorative volcanic glass; should not be confused with ordinary transparent glass unless its behavior is deliberately designed.

Natural formations:
- Basalt pillars, lavafalls, cooled lava shelves, magma pockets and large volcanic arches.
- Ember crystals along warm mineral seams.
- Lava rivers should be contained and should not flood neighboring cave systems through chunk borders.

## 7. Crystal Cavern blocks

- `cave_crystal_ore`: resource-bearing crystal stone.
- `small_crystal_bud`, `medium_crystal_bud`, `large_crystal_bud`, `crystal_cluster`.
- `crystal_block`: storage/decorative block crafted from matching shards.
- `resonant_crystal_block`: rare variant with a future redstone/audio interaction proposal.
- `crystal_glass`: translucent decorative block.
- `crystal_bricks`, stairs, slabs and walls.
- Color variants can include clear, violet, teal and amber; each needs a resource/drop identity or should remain a purely cosmetic palette.

## 8. Fungal and flooded cave blocks

### Fungal Caves
- `fungal_soil`, `spore_moss`, `mycelium_bricks`.
- Giant mushroom cap/stem variants in several natural colors.
- `glow_fungus`, `spore_flower`, `fungal_roots`.
- `fungal_bricks` and decorative variants for building.
- Spore particles must be client-friendly and must not create heavy per-tick effects.

### Flooded Caves
- `cave_reed`, `submerged_roots`, `cave_kelp`.
- `wet_stone`, `waterworn_stone`, `waterworn_bricks`.
- `calcite_pillar`, `calcite_bricks`, stairs/slabs/walls.
- Waterlogged variants only where Forge 1.16.1 block-state support is verified.
- Avoid a new fluid unless vanilla water cannot meet the design need.

## 9. Fossil and ancient ruin blocks

- `large_bone_block`, `fossil_plate`, `fossil_rib`, `fossil_skull`.
- `ancient_stone`, `weathered_ancient_bricks`, `cracked_ancient_bricks`, `chiseled_ancient_bricks`.
- Ancient pillar, stairs, slabs and walls.
- `ruin_lantern`, `sealed_cache_block` or similar functional pieces only when their loot/interaction is fully designed.
- Fossil structures are rare generation features; individual fossil pieces should also be useful as decorative building blocks.

## 10. Nether blocks

### Ashen Wastes
- `ash_block`, `compacted_ash`, `ashstone`, `ashstone_bricks`, `cracked_ashstone_bricks`.
- Ashstone stairs, slabs and walls.
- Ash shrubs and dead-root blocks.

### Emberwood Forest
- Emberwood log, stripped log, wood, stripped wood, planks, leaves and sapling.
- Emberwood stairs, slabs, fences, gates, doors, trapdoors, pressure plates, buttons and signs.
- `emberwood_resin` as a possible drop/material after its gameplay use is defined.
- Ember lantern/ember bulbs as decorative vegetation or light sources.

### Obsidian Caldera
- `caldera_rock`, `caldera_bricks`, `polished_caldera_rock`.
- Obsidian bricks and matching decorative variants.
- `blackstone_pillar`, `magma_crust`, `volcanic_glass`.
- Basalt formations and lava-safe decorative blocks.

### Soulglass Dunes
- `soulglass_sand`, `soulglass`, `cut_soulglass`, `soulglass_bricks`.
- Soulglass stairs, slabs and walls.
- Soulglass panes only after transparency/collision behavior is designed.
- `soulglass_shard` as a possible drop and crafting material.

### Crimson Mire
- `crimson_mire_mud`, `crimson_mire_roots`, `crimson_mire_bricks`.
- Crimson mire vegetation, reeds, fungal caps and root blocks.
- Decorative mud bricks, stairs, slabs and walls.

## 11. End blocks

### Purple Alien Jungle
- `alien_grass_block`, `alien_soil`, `alien_rooted_soil`.
- Alien tree log, stripped log, wood, stripped wood, planks, leaves and sapling.
- Matching stairs, slabs, fences, gates, doors, trapdoors, pressure plates, buttons and signs.
- `alien_vines`, `alien_bloom`, `void_fruit_plant`, `hanging_bulb`.
- `alien_moss` and `alien_moss_carpet`.

### Cold End
- `end_froststone`, `end_ice`, `end_blue_ice`.
- `end_frost_bricks`, `chiseled_end_frost`, ice columns and frost crystals.
- End ice stairs/slabs/walls where appropriate.
- Rare frost ores and decorative crystal clusters.

### Dead Forest
- `dead_end_grass_block`, `dead_end_soil`, `deadwood_log`, `stripped_deadwood_log`, `deadwood_planks`, `deadwood_leaves` (if a leaf-like canopy is used).
- Deadwood stairs, slabs, fences, gates, doors, trapdoors, pressure plates, buttons and signs.
- `deadwood_bricks`, `lilac_stone`, `lilac_stone_bricks`, `cracked_lilac_bricks`, `chiseled_lilac_stone`.
- End Flower with grey stem and lilac petals; planned use as a magenta-dye source.
- Palette: biome #D1A9C7, tree exterior #6E526E, wood/planks #B88DB7.

### Crystal Barrens
- `end_crystal_ore`, `end_crystal_shard`, `end_crystal_block`.
- `crystal_barren_stone`, polished/cracked/chiseled variants.
- Crystal pillars, clusters and optional crystal glass.

### Chorus Wetlands
- `chorus_reed`, `chorus_root_block`, `chorus_mud`, `chorus_mud_bricks`.
- New reed/flower variants and decorative wetland plants.
- Any custom fluid or teleport behavior must be a separate design; do not assume a decorative block needs a new fluid.

### Void Gardens
- `void_garden_soil`, `void_moss`, `void_flower`, `void_leaf_block`.
- `voidstone`, `voidstone_bricks`, polished/chiseled variants.
- Rare `end_shard_ore` or shard-bearing structure blocks; End Shards must remain rare progression resources.

## 12. Ores and raw materials

Possible ore families, with generation depth/location defined separately:
- Sulfur ore → sulfur.
- Crystal ore → crystal shards.
- Ember ore → ember fragments.
- End crystal ore → End crystal shards.
- Frost crystal deposit → frost crystals.
- Deepslate variants of appropriate Overworld ores.

Each resource needs:
- A defined drop and fortune/silk-touch behavior.
- A storage block if enough material exists to justify one.
- A clear crafting, building, utility or progression purpose.
- A generation rate and minimum/maximum depth or biome rule.
- A balanced smelting/blasting or processing route where appropriate.

## 13. Functional and workstation blocks

Candidate functional blocks, subject to separate behavior specifications:
- **Geology Workbench:** inspect/cut selected minerals and craft geological building variants.
- **Crystal Resonator:** future interaction with resonant crystal blocks; no redstone/audio behavior until specified.
- **Volcanic Forge:** process selected high-temperature materials using an appropriate fuel/heat rule.
- **Sulfur Vent Cover:** crafted decorative cover for a natural vent; does not remove the natural hazard unless designed to.
- **End Shard Altar:** rare End structure block for progression interactions, not an ordinary craftable block.
- **Cave Marker/Survey Beacon:** optional utility block for marking a cave region; should be omitted if it adds unnecessary UI or world clutter.

Do not implement all candidate workstations just because they are listed. Start with materials and block families, then add functional blocks with their own interaction, GUI, recipes and server-side validation.

## 14. Technical asset checklist per block

Every registered block needs the applicable pieces:
- Registry entry and matching item entry.
- Block class/properties and correct material/tool behavior.
- Blockstate JSON.
- Block model JSON and item model JSON.
- Texture(s) and connected face/overlay textures if needed.
- English localization entry.
- Loot table.
- Recipe or explicit note that the block is natural-only/unobtainable by crafting.
- Tags for mineable tools, needs-tool, logs/planks/stone/etc. where appropriate.
- Creative tab placement.
- Sound, light and collision settings.
- Explicit note for waterlogging, tile entity/block entity or ticking behavior if relevant.

A placeholder name in this catalogue is not a registered block. Update IMPLEMENTATION-STATUS.md only after source, CI and in-game verification are separately recorded.
