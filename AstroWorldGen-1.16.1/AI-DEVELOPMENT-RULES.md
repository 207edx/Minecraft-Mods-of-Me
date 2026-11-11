# AI Development Rules — AstroWorldGen

These rules apply to ChatGPT, Claude and any other coding assistant working in this repository.

## Non-negotiable version lock

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3
- Mappings 20200820-1.16.1

Do not upgrade the project to a later Minecraft or Forge version to avoid an error.

## Verify before coding

1. Read this project README, feature specification, architecture, generation rules and implementation status.
2. Inspect the actual project files before editing.
3. Verify every Forge/Minecraft class, method, field, event and registry API in the exact 1.16.1 mapped workspace or a known-good 1.16.1 source.
4. Do not assume APIs from 1.16.2, 1.16.5 or later exist in 1.16.1.
5. Make the smallest necessary change and preserve working configuration.
6. Do not claim a feature exists because its design document or placeholder class exists.

## Height engine discipline

- Treat the 500-block target as experimental until tested.
- The current target is Y=0..499 with bedrock at Y=0, not negative Y.
- Do not claim that changing one constant or biome noise creates a functioning 500-block world.
- Keep height patches isolated from biome/structure code.
- Document every transformed target and why it is needed.
- Test block placement, collision, heightmaps, lighting, save/load, client rendering and client/server chunk synchronization.
- Use a disposable test world for chunk-format experiments.

## World-generation discipline

- Generate content through normal world/chunk generation, not commands or player-triggered one-off placement.
- Test new worlds and chunk borders.
- Do not claim previously generated chunks will retroactively regenerate.
- Use seed-deterministic generation; do not use unseeded randomness in chunk generation.
- Keep biome, terrain, cave, feature, structure, loot and mob-spawn registration separate and understandable.
- Check structures, fluids and large features at chunk borders.
- Ensure rare mega-caverns and large structures have bounded frequency and measured performance.
- New worldgen must be dimension-aware and must not silently corrupt vanilla or other modded dimensions.

## Scope and balance

- The feature catalogue is a plan, not a requirement to implement everything in one commit.
- Implement one controlled prototype at a time.
- Every biome needs terrain identity, surface/subsurface blocks, plants, resources, spawn rules and rarity.
- Every ore/resource needs a stated gameplay purpose before its generation becomes common.
- Hazardous cave/biome effects must have clear visual/audio warning and configurable balance.
- Keep generation performance suitable for the target PC and dedicated servers.

## Build and status discipline

- Prefer gradle --no-daemon clean build with the locked JDK/Gradle.
- Do not rewrite Gradle wrapper files, mappings or Forge versions unnecessarily.
- Distinguish source-written, build-verified and in-game-tested.
- A green CI build is not an in-game test.
- Update docs/IMPLEMENTATION-STATUS.md after each verified milestone.
- Never remove existing user features or overwrite IceUpdate without an explicit plan.

## Block and recipe discipline

- Read BLOCKS-CATALOG.md and RECIPES-AND-CRAFTING.md before registering materials.
- Do not add a block registry entry alone and call a block finished.
- For every block, check properties/tool requirements, loot table, blockstate, block model, item model, texture, language entry, tags, creative tab and natural-generation/recipe route.
- Add the matching stairs/slabs/walls only when that material is intended as a building set.
- Wood sets should be consistent across logs, stripped logs, wood, stripped wood, planks, leaves/saplings and matching building forms where relevant.
- Validate all recipe JSON against 1.16.1; verify ingredient/result IDs, counts, recipe unlocks and station type.
- Test Fortune/Silk Touch drops, smelting/blasting, stonecutting, waterlogging, light and collision behavior where applicable.
- Do not create recipes that duplicate rare progression materials or create infinite conversion loops.
- Natural-only blocks and structures must be explicitly marked as non-craftable.

## Collaboration

Before a large change, summarize target files and compatibility risks. Keep commits focused. When a build fails, use the complete compiler output and fix the first real error before making unrelated edits.
