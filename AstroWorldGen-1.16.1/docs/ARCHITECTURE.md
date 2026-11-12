# Architecture

## Design rule

Keep the world content modules independent from the experimental height engine. A failure in chunk storage or lighting must not require rewriting every biome, cave or structure.

## Planned modules

| Module | Responsibility | Dependency |
|---|---|---|
| Core | Mod entry point, common setup, configuration and shared utilities | None |
| Height Engine | Upward build-height expansion and related engine patches | Core; highest-risk module |
| Biome Framework | Biome definitions, climate/elevation intent and biome transitions | Core |
| Overworld Terrain | Taller mountains, plateaus, cliffs, rivers, coastlines and surface rules | Biome Framework; Height Engine for Y>255 |
| Cave Systems | Large caverns, tunnels, underground regions, fluids and cave ecology | Core; terrain integration |
| Winter Worldgen | Frozen biomes, Ice Caves and winter structures | Biome Framework |
| Nether Worldgen | New Nether biomes, volcanic terrain, caves and structures | Biome Framework |
| End Worldgen | Expanded island regions, End biomes, island caves, ores and structures | Biome Framework |
| Stronghold | Overworld Stronghold room/structure redesign | Core |
| Structures and Loot | Shared placement rules, templates, loot tables and structure spacing | Core |
| Compatibility | Config, server checks and integration with other Astro mods | Core |

## World-generation design layers

1. **Region/climate planning:** decide where biome families can appear.
2. **Terrain shape:** create mountains, valleys, islands, volcanic shelves and large cave shapes.
3. **Biome surface:** apply surface blocks, vegetation, fluids and local decoration.
4. **Underground ecosystem:** select cave families and their resources/spawn rules.
5. **Structures:** place biome-appropriate structures with spacing and terrain checks.
6. **Gameplay integration:** connect mobs, items, loot and recipes after the generation itself is stable.

## Implementation order

1. Keep the Forge project bootstrap buildable.
2. Verify exact Forge 32.0.108 world-generation APIs in the mapped source.
3. Add one small natural-generation proof in an existing biome.
4. Add one Overworld custom biome and verify transitions.
5. Add one cave shape proof, then Lush Cave and one additional cave family.
6. Add one Nether biome proof.
7. Add one End biome and a wider-island prototype.
8. Audit and prototype height above Y=255 separately.
9. Connect tall Overworld generation only after the height engine is stable.
10. Expand the remaining biome and structure catalogue in small tested groups.

## Existing IceUpdate project

IceUpdate-1.16.1 remains separate in the same repository. It is a reference for winter mobs, blocks, effects and requested structures. AstroWorldGen is responsible for world terrain, biome placement, cave regions and natural structure placement. Do not copy or depend on IceUpdate code blindly. Inspect its archive, package names, mod ID, assets and build status before deciding on integration.

## Code organization principles

- Common code must be safe on a dedicated server.
- Client rendering and model registration belong in client-only setup.
- Worldgen registration must use actual 1.16.1 Forge APIs, verified against the target workspace.
- Keep height patches isolated from biome/structure code.
- Keep biome, feature, structure, loot and spawn registration separately testable.
- Avoid one giant event handler for all generation.
- Avoid expensive per-block worldgen calculations when a region-level or chunk-level calculation is sufficient.
- Do not introduce later-version APIs or silently upgrade Forge/Minecraft.
