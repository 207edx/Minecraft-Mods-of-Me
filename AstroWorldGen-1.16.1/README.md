# AstroWorldGen 1.16.1

AstroWorldGen expands normal Minecraft 1.16.1 world generation while keeping the target at Forge 32.0.108 and Java 8.

## First world-generation milestone

- Five Overworld biomes: Cherry Grove, Pale Forest, Frozen Pine Valley, Volcanic Badlands and Crystal Springs.
- Custom biome surfaces, climate settings and water palettes.
- Legacy cave carving on custom biomes.
- Overworld cave deposits: deepslate iron, fossils, crystals, cold-region frost deposits, hot-region sulfur/volcanic deposits and wet/forest lush/fungal deposits.
- Nether deposits: caldera rock, ash, emberstone and soulglass.
- Original 16x16 pixel block textures for material families.
- Existing 32 blocks, 6 resource items and 13 crafting recipes remain included.

## Existing-world behavior

The new biomes are added to the normal Overworld biome selection system. New generation rules apply to newly generated chunks; already generated chunks are not rewritten. Back up and test a copy of an existing save before regular play.

## 1.16.1 limitations

Minecraft 1.16.1 predates the later 1.18 underground-biome system. The cave themes here use legacy cave carving and biome-attached deposits, not separate underground biome volumes. Fully custom mega-cave shapes and unique cherry/pale tree species are not in this milestone.

The requested Y=500 build ceiling is **not implemented**. It needs separate engine work for chunk storage, heightmaps, lighting, persistence, networking and rendering.

New Nether/End biomes, End island expansion and custom structures remain future work.

## Build

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3

`gradle --no-daemon clean build`