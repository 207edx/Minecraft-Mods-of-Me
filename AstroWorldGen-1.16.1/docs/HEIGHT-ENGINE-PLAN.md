# Height 500 — Forge 32.0.108 engine investigation

## Required result

- Keep the Overworld floor at Y=0.
- Allow block positions Y=0 through Y=499.
- Expose a build-height boundary of Y=500.
- Generate natural Overworld terrain into the added upper range.
- Existing worlds must still load, save and reload; no existing chunk data may be lost.
- Client and dedicated server must use the same height rules.

## Verified 1.16.1 constraint

The 1.16.1 DimensionType does not contain a minimum-Y or total-height field. Its available height-related setting is logicalHeight, which is not the world build limit. The min_y and height dimension-type model belongs to later Minecraft versions. Therefore, adding a dimension-type JSON file or changing only one height constant cannot produce a real Y=500 Overworld on Forge 32.0.108.

## Engine patch required

This must be treated as an engine-level patch for this exact Minecraft/Forge build, not a normal biome or feature registration. Before a patch is enabled, inspect the 1.16.1 mapped source and trace the complete data path:

1. World/dimension build-limit queries and every Y-bound check.
2. Chunk and ChunkSection storage; the current 16-section vertical range is insufficient.
3. ChunkPrimer/proto-chunk construction and conversion to full chunks.
4. Heightmap storage width, initialization and update rules.
5. Chunk NBT section read/write and region-file persistence.
6. Server chunk packet encode and client chunk packet decode.
7. Sky-light and block-light section arrays and propagation.
8. Chunk rendering, mesh bounds and frustum culling.
9. Collision, entity build-height checks, block placement and structure bounds.
10. Noise sampling, surface building, bedrock placement and structure/feature generation.

## Storage target

A 500-block interval needs 32 backing sections (512 blocks of section storage), with gameplay bounds clamped to Y=0..499. Y=500 is the exclusive upper boundary. Do not expose the extra 12 padding blocks (500..511) as valid build space.

## Safe implementation sequence

1. Source audit and exact Forge 32.0.108 class/member map.
2. Isolated engine prototype that represents a block above Y=255.
3. Save/reload test for blocks and block entities above Y=255.
4. Lighting and renderer test across the upper sections.
5. Dedicated-server/client chunk synchronization test.
6. Only then expand terrain noise and generate the upper mountain range.
7. Test a copy of an existing save and verify it loads without chunk loss or crash.

## Release blockers

Do not mark Y=500 as implemented until placement, collision, lighting, rendering, region saves, reloads, server synchronization and natural terrain generation all pass. Never test a chunk-format patch on the user's only survival save; use a disposable world and backup.
