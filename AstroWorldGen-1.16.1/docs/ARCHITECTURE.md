# Architecture

## Design rule

Keep the project divided into modules so a failure in the experimental height engine does not require rewriting all biome and structure content.

## Planned modules

| Module | Responsibility | Dependency |
|---|---|---|
| Core | Mod entry point, common setup and configuration | None |
| Height Engine | Upward build-height expansion and related engine patches | Core; highest-risk module |
| Overworld Terrain | Taller mountains, plateaus, terrain blending and surface rules | Height Engine |
| Cave Systems | Large caverns, cave networks, underground regions and ore bands | Overworld Terrain |
| Winter Worldgen | Frozen biomes, Ice Caves and winter structures | Core; Height Engine for tall terrain |
| End Worldgen | End biomes, island terrain, cave spaces, ores and End structures | Core |
| Stronghold | Overworld Stronghold room/structure redesign | Core |
| Compatibility | Config, server checks and integration with other Astro mods | Core |

## Initial implementation order

1. Keep the Forge project bootstrap small and buildable.
2. Verify the exact Forge 32.0.108 world-generation APIs in the mapped source.
3. Add one small natural-generation feature as a proof of the worldgen pipeline.
4. Build one test biome/feature in the End and verify it in a fresh world.
5. Build one winter-biome generation prototype.
6. Investigate the height engine independently, starting with blocks above Y=255.
7. Connect tall terrain generation only after the engine prototype is stable.
8. Expand to the full End, winter, cave and structure scope.

## Existing IceUpdate project

`IceUpdate-1.16.1` remains a separate project in this repository. Its feature specification is a reference for winter mobs, blocks, structures and survival mechanics. Do not copy or depend on its code blindly. First inspect its source archive, mod ID, package names, assets and actual build status; then decide whether to port selected features or establish a dependency.

## Source-code policy

- Common code must be safe on a dedicated server.
- Client rendering and model registration belong in client-only setup.
- Worldgen registration must use the actual 1.16.1 Forge lifecycle/API.
- Keep the engine patch behind a dedicated package/module and document every transformed target.
- Do not introduce later-version APIs or quietly upgrade Minecraft/Forge to make code compile.
