# AstroWorldGen — Master Feature Specification

## 1. Project target and rules

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3
- MCP snapshot mappings 20200820-1.16.1
- Mod ID: astroworldgen

Everything described in this document is planned scope unless the implementation tracker explicitly says it is source-written, build-verified or in-game-tested. Features must generate naturally during ordinary world/chunk generation.

## 2. Overworld height and terrain expansion

### 2.1 Vertical limit
- Planned build-height boundary: **Y=500**.
- Planned valid block coordinates: **Y=0 to Y=499**.
- Bedrock remains at **Y=0**.
- This is an upward expansion; negative Y is not part of this milestone.
- The 500-block target is not implemented by this specification. See HEIGHT-ENGINE-PLAN.md.

### 2.2 Surface terrain
- Much taller mountain ranges, high peaks, ridgelines and wind-carved spires.
- Broad high plateaus, elevated valleys, steep cliffs, large ravines and dramatic waterfalls.
- More varied terrain in plains, forests, deserts, savannas, swamps and coastal regions.
- More natural transitions between neighboring biomes and elevations.
- Rivers and lakes should follow terrain shape rather than cut arbitrary straight channels.
- Larger natural forests and woodland clearings, with distinct tree silhouettes and undergrowth.
- Better coastlines, beaches, rocky shores and offshore islands.
- Optional rare mega-landforms should be configurable and should not dominate every seed.

### 2.3 Overworld biome families
See WORLDGEN-CATALOG.md for the complete catalogue. Planned additions include:
- Ancient Redwood Forest, Autumn Woodland, Misty Pine Taiga and Blooming Meadow.
- Wind-Carved Highlands, Alpine Glacier, Cloud Plateau and Highland Valley.
- Crystal Springs, Willow Marsh, Fungal Wetlands and seasonal flower fields.
- New desert, badlands, savanna, coastal and river variants.

New biomes must have their own terrain profile, plants, surface blocks, climate, ambient identity and generation features. They should not be simple palette swaps.

## 3. Underground overhaul and giant caves

The underground must become a major exploration layer, not just a few larger holes.

### 3.1 General cave generation
- Large connected cave networks with long tunnels, branching routes and chambers.
- Enormous caverns with visible floors, ceilings, pillars, arches and natural bridges.
- Multiple cave sizes, from narrow passages to rare mega-caverns.
- Underground lakes, rivers, waterfalls and flooded chambers.
- Cave entrances, skylights and sinkholes that connect the surface to underground areas.
- Biome-aware cave distribution and surface-to-underground blending.
- Cave systems must be deterministic, seed-based and safe across chunk boundaries.
- Avoid excessive cave openings that destroy the surface or leave floating structure fragments.

### 3.2 Lush Caves
- Moss-covered floors and walls, hanging roots, vines, leaf clusters and custom glowing plants.
- Underground trees, root chambers, small waterfalls and clear pools.
- Glowshroom groves, flowering caverns and patches of rare cave vegetation.
- Azalea-like surface clues or root systems that help players discover the caves.
- Passive and neutral cave creatures suited to the ecosystem.
- Rare lush cave gardens with larger trees and hidden resources.

### 3.3 Sulfur Caves
- Yellow sulfur crystals, mineral shelves, sulfur-rich stone and stained rock layers.
- Steam vents, warm pools, mineral chimneys and unusual geologic formations.
- Occasional boiling-water/steam effects as a visual hazard, with clear warning cues and configurable damage.
- Rare sulfur chambers with valuable crafting materials.
- Distinct sound, particles, lighting and atmosphere without making the whole cave permanently obscured.
- Sulfur deposits should have controlled rarity and a use in recipes or materials.

### 3.4 Lava Caves
- Large volcanic caverns with lava rivers, lavafalls, magma pockets and basalt/blackstone formations.
- Obsidian shelves and cooled lava chambers.
- Heat cracks, ember crystals and rare volcanic minerals.
- Fire-resistant cave creatures and nest/ambush spaces.
- Safe navigation pockets and readable visual warnings around dangerous drops.
- Lava should form intentional rivers and lakes, not randomly flood every underground chamber.

### 3.5 Other cave types
- Crystal Caverns: amethyst-like formations, geodes, resonant crystals and rare shards.
- Ice Caves: packed ice, blue ice, frost crystals, icicles and frozen underground pools.
- Fungal Caves: giant mushrooms, mycelium, spores and unusual fungi.
- Flooded Caves: submerged corridors, underground rivers, air pockets and aquatic life.
- Deep Stone Halls: broad stone chambers, pillars, mineral bands and ancient ruins.
- Rare Fossil Chambers: huge bones, fossil blocks and archaeology-style discoveries.
- Cave ecosystems should have their own spawn tables and resources.

Full cave design is in CAVE-SYSTEMS.md.

## 4. Winter world generation

### 4.1 Surface biomes
- Expanded snowy forests, frozen woodlands and pine valleys.
- Frozen highlands, glacial peaks and deep snow basins.
- Glaciers, frozen rivers, ice lakes and wind-swept snowfields.
- Distinct plants, trees, ice formations and wildlife.

### 4.2 Underground and structures
- Rare Ice Caves beneath suitable cold regions.
- Iceologer Castle/Temple at appropriate elevations and terrain.
- Expanded igloo variants, basements and winter ruins.
- Snowy villages and small cold-region camps where suitable.

### 4.3 Existing Winter project coordination
The separate IceUpdate-1.16.1 project contains a broader winter feature design: Frostbite, Iceologer, Ice Golem, penguins, freezing effects, ice crystals, icicles, brittle ice, winter blocks and related mechanics. AstroWorldGen owns terrain, biome and structure generation. Integration must be planned and version-verified; do not copy the existing source blindly or overwrite that project.

## 5. Nether expansion

See NETHER-EXPANSION.md.

Planned Nether biome additions:
- Ashen Wastes.
- Emberwood Forest.
- Obsidian Caldera.
- Soulglass Dunes.
- Crimson Mire.
- Additional basalt caverns and volcanic cave subregions.

Planned terrain improvements:
- More varied volcanic shelves, cliffs, ridges, caves and lava basins.
- Better transitions between vanilla and custom Nether biomes.
- New Nether vegetation, resource veins, mobs and structure placements.
- Nether ruins, lava observatories, ash-covered outposts and dangerous fortress-adjacent discoveries.

The initial 500-block height target is for the Overworld only. Nether height must be treated as a separate compatibility decision.

## 6. Ultimate End Update

See END-EXPANSION.md.

### 6.1 Wider End
- Increase the scale and variety of outer End island regions.
- Generate broad island chains and archipelagos, separated by navigable void gaps.
- Add very large islands with internal cave networks and hidden chambers.
- Add floating island layers at different elevations, cliffs, bridges, spires and island undersides.
- Preserve the central arrival island and a clear progression route to outer islands.
- Make the expanded End feel explorable and coherent rather than an endless flat ring.

### 6.2 End biomes
- Purple Alien Jungle.
- Cold/Icy End.
- Dead Forest.
- Crystal Barrens.
- Chorus Wetlands.
- Void Gardens.

Each biome needs unique terrain, plants, resources, structures and appropriate mobs.

### 6.3 End features and structures
- Alien trees, vines, flowers, strange grasses and giant fungal/plant formations.
- End caves inside large islands, with crystals, hidden lakes and rare resources.
- End Ruins, watchposts, small huts, observatories and hidden libraries.
- Rare high-difficulty structures with valuable loot and environmental clues.
- Ordinary ruins must not be overloaded with armour, weapons or horse armour.

### 6.4 End palette and named progression
Dead Forest visual direction:
- Biome tone: #D1A9C7.
- Dead tree exterior: #6E526E.
- Wood/planks: #B88DB7.
- End Flower: grey stem with lilac petals; planned as a magenta-dye source.

End Shards:
- Rare End resource.
- Planned to enhance a Totem of Undying.
- On activation, the enhanced totem searches for a safe ground position within a small radius (original concept: 5 blocks).
- Destination checks must reject air, lava and unsafe placements.

Potion of Returning:
- Planned brewing recipe using End Shards.
- Teleports the player to the configured world spawn point.

Void Totem:
- Separate rare item from a difficult End structure.
- Intended to rescue a player from the void.
- Must remain distinct from the End-Shard-enhanced Totem.

Other planned progression:
- Levitation potion brewed with Shulker Shells; exact recipe and balance to be designed.
- Phantoms move to the End by default, with configuration to keep or restore Overworld spawning.

## 7. Stronghold and Overworld discovery

- More varied Stronghold room shapes, libraries, storage rooms and broken corridors.
- Secret passages, hidden switches, puzzles and readable traps.
- Preserve a connected route to the End Portal room.
- New ruins, watchposts, abandoned camps, cave shrines and rare discovery sites.
- Hidden books, maps and environmental clues that reward exploration.

## 8. World-generation quality rules

See GENERATION-RULES.md.

- Features generate from world seed during normal chunk generation.
- No command-only or player-triggered generation.
- Structures must avoid chunk-border gaps and invalid placement.
- Biomes must blend naturally and respect climate/elevation rules.
- Configurable frequency for large rare structures and mega-caverns.
- No excessive overlap of large structures or biome features.
- Respect existing vanilla dimensions and avoid breaking modded dimensions.



## 10. Blocks, variants and crafting

The detailed material catalogue is maintained in BLOCKS-CATALOG.md and recipe progression in RECIPES-AND-CRAFTING.md.

Planned additions include:
- Deepslate, cobbled/polished deepslate, bricks, tiles, chiseled blocks, pillars, stairs, slabs, walls and matching ore variants.
- Lush Cave moss, carpets, rooted soil, hanging roots, vines, glowmoss, glowshrooms and cave flowers.
- Ice/Froststone, packed frost ice, blue frost ice, snow bricks, icicles, frost crystals and natural Ice Spike formations.
- Sulfur ore, sulfur stone, sulfur crystals, sulfur vents and mineral crust.
- Volcanic rock, ash, emberstone, basalt/obsidian decorative variants and ember crystals.
- Crystal, fungal, flooded-cave, fossil and ancient-ruin block families.
- Nether Ashstone, Emberwood, Soulglass, Caldera Rock and Crimson Mire materials.
- End alien wood/soil, Deadwood, lilac stone, End froststone, crystal-barren blocks, chorus wetland and void-garden materials.
- Matching wood families, stone variants, stairs, slabs, walls, doors, trapdoors, fences, gates, signs, buttons and pressure plates where each material supports them.
- Functional block candidates such as Geology Workbench, Crystal Resonator, Volcanic Forge and End Shard Altar.

Recipe requirements:
- Use shaped, shapeless, stonecutter, smelting and blasting recipes as appropriate for Minecraft 1.16.1.
- Give every ore/resource a defined drop and crafting use.
- Keep rare natural structures and progression materials rare; do not make them trivially craftable.
- Add blockstates, block/item models, textures, loot tables, tags and language entries for every registered block.
- Mark natural-only blocks clearly when they do not have a crafting recipe.

All entries remain planned until registered, built and tested in-game. See BLOCKS-CATALOG.md and RECIPES-AND-CRAFTING.md.

## 11. Acceptance criteria

A feature is not complete merely because a Java class, registry entry or JSON file exists.

A generation feature is accepted only after:
1. It appears naturally in a fresh world or newly generated chunks.
2. It has the intended biome/terrain identity.
3. It generates safely at chunk borders and does not create broken terrain.
4. Its blocks, entities, loot and structures work.
5. The world saves, closes and reloads correctly.
6. Client and dedicated-server behavior is verified.
7. Performance and spawn/loot balance are checked.
8. IMPLEMENTATION-STATUS.md records what was actually tested.
