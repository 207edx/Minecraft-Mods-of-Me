# Natural World-Generation Rules

## Core requirement

All world content must appear through normal world generation. The player should create a world, explore naturally and discover biomes, caves, ores and structures without commands or manual activation.

## 1. Seed determinism

- The same world seed and generation settings should produce the same terrain and placements.
- Do not use unseeded random values in chunk generation.
- Features must not depend on the order in which players explore chunks.
- Test generation by visiting chunks in different orders and compare results.

## 2. Chunk borders

- Structures and large features must generate consistently when they cross chunk boundaries.
- Avoid half-built structures, missing walls, duplicated decorations or fluid leaks at borders.
- Place large features through the correct worldgen/structure mechanisms for 1.16.1, verified against the mapped source.
- Test at negative and positive chunk coordinates even though the planned build floor remains Y=0.

## 3. Biome placement and blending

- Use climate, elevation and neighboring biome rules to make transitions believable.
- Avoid random patches that look like unrelated biomes were pasted together.
- Preserve recognizable vanilla biome regions unless a documented compatibility setting says otherwise.
- Keep special/rare biomes rare enough to remain discoveries.
- Use appropriate terrain shape, surface blocks, vegetation and spawn tables for each biome.

## 4. Cave integration

- Cave networks should connect logically with surface terrain and underground regions.
- Lush caves should favor suitable wet/temperate regions; Ice Caves should favor cold regions; Lava Caves and sulfur regions should follow defined geological rules.
- Underground lakes and lava chambers must be generated with clear containment rules.
- Do not let fluid features flood unrelated structures or produce unsafe chunk-edge leaks.

## 5. Structure placement

- Check terrain suitability, biome restrictions, height, slope, water and neighboring structure overlap.
- Place structure pieces consistently across chunk boundaries.
- Preserve required vanilla progression structures and routes.
- Use configurable spacing and separation for large rare structures.
- Keep structure loot in separate, testable tables.

## 6. Performance

- Avoid very expensive noise calculations repeated for every block.
- Cache or reuse immutable generation settings safely.
- Keep feature density, entity spawns and structure checks bounded.
- Profile chunk-generation time and memory use on the target version.
- The user's older test PC makes performance and memory measurements especially important; provide a reduced-feature test configuration when practical.

## 7. Configuration

Planned configuration groups:
- Overworld biome frequency and terrain intensity.
- Cave system frequency and mega-cavern chance.
- Sulfur vent and lava chamber density.
- Winter biome and Ice Cave rarity.
- Nether biome and structure frequency.
- End radius/scale, biome frequency and rare structure chance.
- Optional phantom spawn compatibility behavior.
- Experimental 500-block height enablement, disabled by default until validated.

Changing configuration must not corrupt already generated chunks. Document which settings are world-creation-only and which affect newly generated chunks.

## 8. Testing

- Generate a fresh world with a known seed.
- Test at least several unrelated seeds before deciding generation is balanced.
- Explore neighboring chunks in different orders.
- Confirm the same seed is deterministic.
- Save, quit, reload and revisit generated regions.
- Run a dedicated server and connect a separate client.
- Record screenshots, logs, world seed, config and exact Forge version in the implementation tracker.
