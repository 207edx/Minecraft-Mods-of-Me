# AstroWorldGen — Forge 1.16.1

**A large world-generation and world-expansion project for Minecraft 1.16.1.**

AstroWorldGen is planned as a broad world update: a much larger and more varied Overworld, giant connected cave systems, a winter biome expansion, a richer Nether, and a substantially wider End with new biomes, structures, resources and discoveries.

> **Current milestone: first block batch build-verified.** GitHub Actions successfully compiled and reobfuscated the starter mod with 32 placeable base blocks, 6 resource items and 13 recipes, then uploaded a JAR and source ZIP. In-game registration and recipe loading still need testing. Biome placement, custom textures, stairs/slabs/walls, cave generation and the 500-block height remain separate work.

## Locked target

- Minecraft: **1.16.1**
- Forge: **32.0.108**
- Java: **8**
- Gradle: **4.10.3**
- MCP mappings: **20200820-1.16.1**
- Mod ID: **astroworldgen**
- Planned Overworld build-height boundary: **Y=500**
- Bedrock floor: **Y=0**
- Planned valid Overworld build coordinates: **Y=0 through Y=499**

The height target is upward expansion only. It does not include negative Y. It is an engine-level milestone, not a normal biome setting.

## Main world updates

### Overworld — taller, wider-feeling terrain
- Taller mountain ranges, enormous peaks, high plateaus, cliffs, ravines and broad valleys.
- More distinct forests, meadows, wetlands, drylands and high-altitude regions.
- Better biome transitions, rivers, lakes, coastlines and terrain blending.
- A vertical landscape designed around the planned 500-block build-height boundary.

### Underground — large cave ecosystems
- Large, branching cave networks, giant caverns and underground lakes.
- **Lush Caves** with moss, roots, glowing plants, water pools and underground vegetation.
- **Sulfur Caves** with sulfur deposits, mineral shelves, steam vents and rare geologic chambers.
- **Lava Caves** with lava streams, basalt, blackstone, magma pockets and heat-adapted life.
- Crystal Caverns, Ice Caves, fungal caves and flooded cave systems.
- Cave-specific resources, ambience, plants, mobs and structures.

### Winter Update
- Snowy forests, frozen highlands, glaciers and new cold-region variants.
- Ice Caves, Iceologer sites, expanded igloos and winter ruins.
- Coordinated design with the separate [IceUpdate-1.16.1 project](../IceUpdate-1.16.1/README.md), without overwriting it.

### Nether Expansion
- New regions such as Ashen Wastes, Emberwood Forest, Obsidian Caldera, Soulglass Dunes and Crimson Mire.
- Wider volcanic landscapes, dramatic basalt formations, lava-fed caverns and new Nether structures.
- Biome-specific vegetation, mobs, resources and progression.

### Ultimate End Update
- A larger End made from broad island regions, floating archipelagos, high cliffs and huge islands with internal caves.
- Purple Alien Jungle, Cold End, Dead Forest, Crystal Barrens, Chorus Wetlands and rare Void Gardens.
- End Ruins, watchposts, observatories, hidden libraries and difficult rare structures.
- End-exclusive resources and progression, including End Shards and the separate Void Totem concept.

### Stronghold and exploration
- More varied Stronghold rooms, secret passages, puzzles, traps and rewards.
- World-seed discoveries, environmental clues and new points of interest.

## Blocks, materials and recipes

AstroWorldGen has a full block catalogue covering Deepslate, Lush Cave growth, Ice Spikes and frost blocks, sulfur, volcanic and crystal materials, Nether sets, End wood/stone families and decorative variants. The first 32 base blocks and 6 resource items are now registered in source with block/item models, blockstates, loot tables and language names. Thirteen starter crafting recipes are included. These first-pass models reuse vanilla textures as placeholders; custom textures, extra shape variants and natural placement are still pending.

- [Blocks and material variants](docs/BLOCKS-CATALOG.md)
- [Crafting and processing recipes](docs/RECIPES-AND-CRAFTING.md)

## Project documents

- [Full feature specification](docs/FEATURE-SPEC.md)
- [Biome catalogue](docs/WORLDGEN-CATALOG.md)
- [Cave systems catalogue](docs/CAVE-SYSTEMS.md)
- [Nether expansion](docs/NETHER-EXPANSION.md)
- [End expansion](docs/END-EXPANSION.md)
- [Natural generation rules](docs/GENERATION-RULES.md)
- [Height-engine plan](docs/HEIGHT-ENGINE-PLAN.md)
- [Architecture](docs/ARCHITECTURE.md)
- [Implementation status](docs/IMPLEMENTATION-STATUS.md)
- [Development setup](docs/DEV-SETUP.md)
- [AI development rules](AI-DEVELOPMENT-RULES.md)

## Height-engine note

Minecraft 1.16.1 was built around a 0–255 vertical range. A build-height boundary of 500 requires coordinated work across chunk sections, heightmaps, lighting, serialization, network packets, collision and client rendering. See the height-engine plan. The project must not claim the 500-block limit works until blocks above Y=255 can be placed, saved, reloaded, lit and synchronized.

## Build and downloads

Use JDK 8 and Gradle 4.10.3:

    gradle --no-daemon clean build

The reobfuscated JAR is created in build/libs/. GitHub Actions builds the project and uploads both the compiled JAR and a source ZIP as workflow artifacts.

A successful CI build verifies compilation/reobfuscation only. It does not mean every planned biome, cave, structure or height feature has been implemented or tested in Minecraft.

## Testing rules

- Generate content during normal world/chunk generation, not from commands or player-triggered one-off placement.
- Use a new world or newly generated chunks for worldgen tests. Existing explored chunks do not regenerate automatically.
- Test chunk borders, save/reload, client rendering and dedicated-server behavior.
- Use disposable test worlds for experimental height or chunk-format work.
- Record the exact tested version and evidence in IMPLEMENTATION-STATUS.md.
