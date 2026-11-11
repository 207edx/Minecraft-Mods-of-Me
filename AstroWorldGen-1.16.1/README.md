# AstroWorldGen — Forge 1.16.1

**A large-scale world-generation and world-expansion project for Minecraft 1.16.1.**

AstroWorldGen brings the planned End Update, winter-biome generation, expanded underground networks and a taller Overworld into one separately maintained mod project.

> **Current milestone: project foundation.** The files in this first milestone establish the Forge project, feature specifications, engineering plan and CI build. They do not claim that the planned biomes, structures or 500-block height are already implemented.

## Locked target

- Minecraft: **1.16.1**
- Forge: **32.0.108**
- Java: **8**
- Gradle: **4.10.3**
- MCP mappings: **20200820-1.16.1**
- Mod ID: `astroworldgen`
- Planned Overworld build height: **500 blocks**
- Bedrock floor: **Y=0**

For this project, “build height 500” currently means valid block coordinates **Y=0 through Y=499**, with the upper build boundary at Y=500. Bedrock remains at Y=0. This is an upward expansion, not a negative-Y expansion.

## Feature pillars

### 1. Taller Overworld and underground overhaul
- Raise the build-height ceiling from the 1.16.1 vanilla limit to the planned 500-block limit.
- Keep the bedrock floor at Y=0.
- Generate taller mountains, high plateaus, cliffs and more varied vertical terrain.
- Add larger and more connected cave systems, deep caverns, underground lakes and new underground biome areas.
- Rework vertical terrain/noise and ore distribution so the extra height is meaningful, not just empty space.

### 2. Winter world generation
- Add natural snowy, frozen and glacial biome variants.
- Generate Ice Caves and related underground cold areas beneath suitable cold regions.
- Add winter structures such as Iceologer locations, expanded igloos and other cold-region discoveries.
- Coordinate with the existing [IceUpdate-1.16.1](../IceUpdate-1.16.1/README.md) project so its mobs, blocks and mechanics can be integrated or adapted without overwriting that project.

### 3. Ultimate End Update
- Purple Alien Jungle biome with alien vegetation and a distinct ecosystem.
- Cold/Icy End biome.
- Dead Forest biome using the planned muted lilac palette.
- Taller End terrain, floating island chains, large islands with internal cave spaces and new End ores.
- End Ruins, watchposts, huts and rare high-difficulty structures.
- End Shards, the Void Totem and other End progression features.
- Phantoms moved to the End by default, with a configuration option to preserve Overworld spawning.

### 4. Stronghold and discovery improvements
- More varied Stronghold rooms, hidden passages, puzzles and rewards.
- Biome-specific secrets, books, ruins and environmental discoveries.

See [FEATURE-SPEC.md](docs/FEATURE-SPEC.md) for the full planned scope.

## Important height-limit engineering note

Minecraft 1.16.1 was built around a 0–255 vertical range. Raising the ceiling to 500 is not just a biome or noise-generator setting. Chunk section storage, heightmaps, lighting, chunk serialization, network packets, collision and client rendering all need to be inspected and tested together.

The 500-block height feature is therefore a separate experimental engineering milestone. See [HEIGHT-ENGINE-PLAN.md](docs/HEIGHT-ENGINE-PLAN.md). No height modification is advertised as working until blocks above Y=255 can be placed, saved, reloaded, lit and synchronized between client and server.

## Build

Use JDK 8 and Gradle 4.10.3:

```bash
gradle --no-daemon clean build
```

The reobfuscated mod JAR should appear in `build/libs/`.

GitHub Actions is configured to compile this project and upload the JAR as a workflow artifact. A successful CI build verifies compilation and reobfuscation; it does **not** prove the world-generation features work in-game.

## Testing rules

- Test world-generation changes in a new world or newly generated chunks.
- Existing chunks are not retroactively regenerated.
- Test both single-player and a dedicated server.
- Test save, quit, reload and re-enter before marking a feature complete.
- Keep the original Minecraft installation and valuable saves untouched during experimental height testing.

## Project documents

- [Feature specification](docs/FEATURE-SPEC.md)
- [Height-engine plan](docs/HEIGHT-ENGINE-PLAN.md)
- [Architecture](docs/ARCHITECTURE.md)
- [Implementation status](docs/IMPLEMENTATION-STATUS.md)
- [Development setup](docs/DEV-SETUP.md)
- [AI development rules](AI-DEVELOPMENT-RULES.md)
