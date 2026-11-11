# AI Development Rules — AstroWorldGen

These rules apply to ChatGPT, Claude and any other coding assistant working in this repository.

## Non-negotiable version lock

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8
- Gradle 4.10.3
- Mappings `20200820-1.16.1`

Do not upgrade the project to a later Minecraft or Forge version to avoid an error.

## Verify before coding

1. Read this project README, feature specification, architecture and implementation status.
2. Inspect the actual project files before editing.
3. Verify every Forge/Minecraft class, method, field, event and registry API in the exact 1.16.1 mapped workspace or a known-good 1.16.1 source.
4. Do not assume APIs from 1.16.2, 1.16.5 or later exist in 1.16.1.
5. Make the smallest necessary change and preserve working configuration.

## Height engine discipline

- Treat the 500-block target as experimental until tested.
- Do not claim that changing one constant or biome noise creates a functioning 500-block world.
- Keep height patches isolated from biome/structure code.
- Document every transformed class/member and why it is needed.
- Test block placement, collision, heightmaps, lighting, save/load, client rendering and client/server chunk synchronization.
- Use a disposable test world for chunk-format experiments.

## World-generation discipline

- Generate content through normal world/chunk generation, not commands or player-triggered one-off placement.
- Test new worlds and chunk borders.
- Do not claim previously generated chunks will retroactively regenerate.
- Keep biome, feature, structure, loot and mob-spawn registration separate and understandable.

## Build and status discipline

- Prefer `gradle --no-daemon clean build` with the locked JDK/Gradle.
- Do not rewrite Gradle wrapper files, mappings or Forge versions unnecessarily.
- Distinguish source-written, build-verified and in-game-tested.
- A green CI build is not an in-game test.
- Update `docs/IMPLEMENTATION-STATUS.md` after each verified milestone.
- Never remove existing user features or overwrite the IceUpdate project without an explicit plan.

## Collaboration

Before making a large change, summarize the target files and compatibility risks. Keep commits focused. When a build fails, use the complete compiler output and fix the first real error before making unrelated edits.
