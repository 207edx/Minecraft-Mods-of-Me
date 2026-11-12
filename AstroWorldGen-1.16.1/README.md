# AstroWorldGen 1.16.1

AstroWorldGen expands normal Minecraft 1.16.1 world generation and gameplay content for Forge 32.0.108 / Java 8.

## Included in this source milestone

- Five registered Overworld biome prototypes: Cherry Grove, Pale Forest, Frozen Pine Valley, Volcanic Badlands and Crystal Springs.
- Themed cave chamber generation for cold, lush, sulfur/volcanic and crystal cave types, using 1.16.1 chunk processing.
- Ice cave details adapted from the supplied IceUpdate source: Brittle Ice, directional Ice Crystals and falling Icicles.
- Penguin creature with its own model, texture, renderer and spawn egg; it wanders, swims, follows fish and slides on ice/snow.
- The original AstroWorldGen material blocks, resource items and starter crafting recipes.
- Custom pixel-art material and penguin textures.

## Existing-world behavior

The new biome weights participate in normal Overworld biome selection. Existing chunks retain their saved biome and block data; newly generated chunks can select the added biomes. The cave pass only runs in AstroWorldGen's custom biomes and stores a per-chunk NBT marker so it does not carve the same chunk repeatedly. Test a copy of an existing save first.

To see the new biome and cave content, explore areas that have not generated chunks before installing the mod. Both server and clients must have the same mod build for multiplayer.

## Minecraft 1.16.1 limitations and unfinished work

- 1.16.1 has no separate 1.18-style underground-biome volumes. The cave themes are generated chambers and block palettes, not full 3D underground biomes.
- The custom surface biomes are first prototypes; unique tree species, custom vegetation sets and detailed biome blending still need work and in-game verification.
- Larger continuous mega-caves, rare cave structures, custom Nether/End biomes and expanded End islands remain unfinished.
- The requested Y=500 build ceiling is not implemented. It needs a separate engine-level investigation of chunk sections, heightmaps, lighting, saving, networking and rendering.
- CI success verifies compilation and packaging only; it does not prove in-game world compatibility.

## Build

Required:
- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3

From this folder:

```bash
gradle --no-daemon clean build
```

GitHub Actions builds the same toolchain and uploads the JAR and source ZIP.
