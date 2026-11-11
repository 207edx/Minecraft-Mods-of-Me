# Height 500 — Engine Investigation and Prototype Plan

## Goal

Extend the Overworld upward while retaining the existing bedrock floor:

- Minimum build coordinate: Y=0.
- Bedrock floor: Y=0.
- Target build-height boundary: Y=500.
- Under the current interpretation, valid block coordinates are Y=0 through Y=499.
- No negative-Y support is included in this milestone.

## Why this is not a normal world-generation change

Minecraft 1.16.1 uses a fixed-height chunk/world model. Raising the terrain noise range or changing a single maximum-height value does not automatically enlarge every system that stores, transmits, lights, renders or saves chunk sections.

The implementation must be based on the exact Forge 32.0.108 and 1.16.1 mapped source. Do not copy class names, fields or method signatures from later Minecraft versions without verifying them.

## Source-audit checklist

Inspect the 1.16.1 source/decompiled Forge workspace and record the actual mapped class/member names for:

- World and dimension build-height queries.
- Chunk and chunk-section arrays.
- Chunk primer/proto-chunk construction.
- Heightmap types and storage width.
- Chunk serialization/deserialization and saved section lists.
- Chunk packet encoding/decoding and client chunk application.
- Server and client chunk caches.
- Sky/block-light storage and propagation.
- Client chunk meshes, render bounds and frustum visibility.
- Collision, entity build-height checks and block placement limits.
- World generation settings, noise sampling and surface building.
- Structure placement bounds, feature placement and biome generation.

Likely source search terms include `Chunk`, `ChunkSection`, `Heightmap`, `ChunkSerializer`, `LightEngine`, `ChunkData`, `WorldGenRegion`, `ChunkGenerator` and build-height methods. Treat these as search terms, not a promise that every name maps exactly as written.

## Technical work items

### A. Vertical section storage
A 500-block range spans more than the vanilla 16 vertical sections. A 32-section backing range would cover 512 blocks, but the exact representation and boundary rules must be confirmed in the 1.16.1 source. Only Y=0..499 should be exposed as buildable if the chosen ceiling remains 500.

### B. Heightmaps and coordinate bounds
Audit heightmap bit width, height queries, min/max comparisons, build limits and every place that assumes a 256-block vertical range.

### C. Lighting
Verify sky-light initialization, propagation, section boundaries, relighting and light updates for the added upper sections. Lighting errors are a release blocker.

### D. Persistence
Verify that all extra sections are written to region files, loaded back, and retained after a full game restart. Test blocks, block entities and scheduled updates in the extended range.

### E. Network protocol
Verify server-to-client chunk section data, heightmaps and light data. A single-player-only test is not enough; both client and dedicated server must agree on the vertical range.

### F. Rendering and interaction
Verify camera clipping, chunk mesh generation, frustum culling, block selection, placement, breaking, entity movement and collision above Y=255.

### G. Terrain generation
Only after the storage and engine prototype is stable should the Overworld noise/surface generator be expanded. The new 244-block upper band must contain designed terrain rather than an empty extension.

## Prototype milestones

1. **Audit:** identify each hard-coded/fixed-height assumption in the exact 1.16.1 mapped workspace.
2. **Patch design:** choose and document the least invasive compatible patch mechanism. Do not add a Mixin/coremod dependency until its 1.16.1/Forge compatibility is verified.
3. **Section prototype:** create a local test proving the game can represent a block above Y=255.
4. **Persistence test:** save, quit, relaunch and confirm the block remains.
5. **Lighting/render test:** verify light, visibility, selection and collision above Y=255.
6. **Network test:** verify the same result on a dedicated server and client.
7. **Worldgen test:** generate natural terrain up to the new ceiling.
8. **Performance/compatibility test:** profile chunk generation and test with a clean Forge instance.

## Release blockers

Do not mark height 500 as implemented until all of the following work:

- Blocks can be placed and broken above Y=255.
- Blocks and block entities survive save/reload.
- Lighting and rendering work.
- Chunks synchronize between client and server.
- Natural terrain and structures generate within the expanded range.
- No crash occurs when loading a world with extended sections.

## Safety for test worlds

Use a disposable new world and a separate development profile. Never test experimental chunk-format or height patches on a valuable survival save. Keep backups before every save-format experiment.
