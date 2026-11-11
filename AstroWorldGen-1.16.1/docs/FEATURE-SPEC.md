# AstroWorldGen Feature Specification

## 1. Project target

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3
- MCP snapshot mappings: `20200820-1.16.1`
- Mod ID: `astroworldgen`

All planned content must generate through normal biome, chunk, structure and feature generation. It must not depend on commands or on a player manually triggering generation.

## 2. Overworld vertical expansion

### 2.1 Height target
- Planned build-height boundary: **Y=500**.
- Valid block coordinates under this interpretation: **Y=0 to Y=499**.
- Bedrock remains at **Y=0**.
- The project is intentionally pursuing upward expansion first; negative Y is not part of this milestone.
- The 500-block limit is a target, not an implemented capability yet.

### 2.2 Surface terrain
- Taller mountain ranges with high peaks and ridges.
- Broad elevated plateaus, steep cliffs and dramatic valleys.
- More vertical variation between plains, forests, mountains and other Overworld regions.
- New high-altitude and mountain biome variants where generation rules make them distinct.
- Terrain should blend between biomes instead of creating abrupt, artificial walls.

### 2.3 Underground and cave overhaul
- Larger cave networks with branching passages and connected caverns.
- Deep chambers, underground lakes and water-filled cave areas.
- New cave-themed underground biome areas with their own blocks, vegetation, atmosphere and spawn rules.
- Additional stone/deep-stone layers and ore distribution suited to the expanded vertical world.
- Cave openings and terrain must avoid exposing broken or floating structure pieces.

### 2.4 Natural generation
- Terrain, caves, ores, biome features and structures generate during ordinary world/chunk generation.
- New worlds are the primary test target.
- Existing explored chunks do not regenerate automatically.
- Generation must be deterministic for a world seed and safe at chunk borders.

## 3. Winter biome update

### 3.1 Surface biomes
- Expanded snowy forests and frozen woodland.
- Frozen highlands and taller snowy mountain regions.
- Glacial areas, frozen rivers and lakes, and suitable transition zones.
- Distinct snow/ice palettes and vegetation rather than simply recoloring a vanilla biome.

### 3.2 Winter underground
- Rare Ice Caves beneath suitable frozen regions.
- Ice/calcite cave walls, crystals, icicles, frozen pools and fragile ice variants.
- Cold underground spawn conditions and biome-specific ambience.
- Cave entrances and major structures should fit naturally into the terrain.

### 3.3 Winter structures and ecosystem
- Iceologer Castle/Temple in suitable snowy highlands.
- Expanded igloo variants and basement layouts.
- Cold-region ruins and additional discovery sites.
- Coordinate with the existing IceUpdate project for planned Frostbite, Iceologer, Ice Golem, penguins, winter blocks, freezing effects and related mechanics. The existing IceUpdate project is not modified by this foundation commit.

## 4. Ultimate End Update

### 4.1 End biomes
- **Purple Alien Jungle:** surreal alien vegetation, unusual terrain, new plants and a distinct mob ecosystem.
- **Cold End:** icy terrain, cold vegetation and suitable cold-adapted creatures.
- **Dead Forest:** grey-lilac landscape and distinctive dead trees.

Dead Forest palette requested for the visual direction:
- Biome tone: `#D1A9C7`
- Dead tree exterior: `#6E526E`
- Wood/planks: `#B88DB7`
- End Flower: grey stem with lilac petals; planned as a magenta-dye source.

### 4.2 End terrain and caves
- More vertical terrain variation and floating island chains.
- Large islands with internal cave spaces.
- New End ores and resources.
- New plants, vines, creatures and environmental secrets.
- Biome transitions and island placement must feel like a coherent End ecosystem.

### 4.3 End structures
- End Ruins inspired by the discovery role of Ocean Ruins: watchposts, huts and scattered remnants.
- Rare high-difficulty structures with valuable, biome-appropriate loot.
- Ordinary ruins should not become a source of excessive armour, weapons or horse armour.
- Hidden books and environmental clues can lead players toward rare discoveries.

### 4.4 End progression items and mechanics
- **End Shards:** rare End resource. Planned use: enhance a Totem of Undying so its activation relocates the holder to a nearby safe ground position within the requested small radius. The destination must be checked for solid ground and must not be inside lava or open air.
- **Potion of Returning:** planned potion brewed using End Shards; returns the player to the configured world spawn point.
- **Void Totem:** separate rare reward from a difficult End structure, intended to rescue a player from the void. It is distinct from the End-Shard-enhanced Totem.
- **Potion of Levitation:** planned brewing path using Shulker Shells; recipe and balance still need design.
- **Phantoms:** planned to spawn in the End by default. A configuration option should preserve or restore their Overworld spawning for players who prefer vanilla behavior.

## 5. Stronghold redesign

- More room variety and clearer progression through the structure.
- Secret corridors and hidden rooms.
- Puzzles and traps that are fair and readable.
- Better rewards that encourage exploration without replacing End City progression.
- Generation must remain connected and preserve access to the End Portal room.

## 6. Configuration and compatibility

- Configurable world-generation rates where practical.
- Options for phantom spawn behavior and major structure frequency.
- Avoid forcing generation into dimensions where a feature does not belong.
- Do not silently change another mod's biome or structure registrations.
- Keep client-only rendering code separate from common/server code.
- Test dedicated-server startup and world loading.

## 7. Acceptance criteria

A feature is not complete merely because its class or JSON file exists.

A world-generation feature is accepted only after:
1. It appears naturally in a new world or newly generated chunks.
2. It generates safely at chunk borders and does not create broken terrain.
3. Its blocks, entities, loot and structure pieces are usable.
4. The world saves, closes and reloads correctly.
5. Client and dedicated-server behavior is verified.
6. Its status is recorded in `IMPLEMENTATION-STATUS.md`.
