# AstroWorldGen 1.16.1

AstroWorldGen expands normal Minecraft 1.16.1 world generation and gameplay content for Forge 32.0.108 / Java 8.

## Included in this source milestone

- Five registered Overworld biome prototypes: Cherry Grove, Pale Forest, Frozen Pine Valley, Volcanic Badlands and Crystal Springs.
- Additional cave and canyon carvers in Overworld biomes, increasing cave frequency for newly generated chunks.
- Biome/climate-based mineral deposits: frost, sulfur, volcanic, lush, crystal and fossil materials.
- Caldera rock, ash, emberstone and soulglass deposits in existing Nether biomes.
- Ice cave details adapted from the supplied IceUpdate source: Brittle Ice, directional Ice Crystals and Icicles.
- Penguin creature with its own model, texture, renderer and spawn egg; it wanders, swims, follows fish and slides on ice/snow.
- Original AstroWorldGen material blocks, resource items, starter recipes and custom pixel-art textures.

## Existing-world behavior

Biome selection, cave carving and ore/mineral placement use Minecraft's normal chunk-generation pipeline. Already generated chunks are not edited when they load. New generation rules apply to newly generated chunks only. Explore unexplored areas to find the new content.

For multiplayer, the server and clients must use the same mod build. The server produces the generated chunk contents, and clients need the matching registry entries and assets to display them.

## Minecraft 1.16.1 limitations and unfinished work

- 1.16.1 has no separate 1.18-style underground-biome volumes. Cave themes currently use carvers and biome-specific deposits, not full 3D cave biome regions.
- Large themed cave chambers, underground rivers, cave structures and unique cherry/pale tree species remain unfinished.
- New Nether/End biomes, expanded End islands and their structures remain unfinished.
- The requested Y=500 build ceiling is not implemented. 1.16.1 needs engine-level changes to chunk section storage, heightmaps, lighting, saving, networking, collision and rendering.
- A successful CI build verifies compilation and packaging only; it does not prove in-game world compatibility.

## Build

Required:
- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3

From this folder:

~~~bash
gradle --no-daemon clean build
~~~

GitHub Actions builds the same toolchain and uploads the JAR and source ZIP.
