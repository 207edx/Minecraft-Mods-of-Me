# Implementation Status

**Current state: project foundation + design catalogue. The foundation Forge build passed once in GitHub Actions. No world-generation feature is yet claimed as in-game implemented.**

| Area | Status | Next proof required |
|---|---|---|
| Forge project layout | Build verified | Keep CI green while modules are added |
| Mod entry point | Build verified | Confirm Forge 32.0.108 loads in-game |
| GitHub Actions build | Build verified | Re-run after expanded docs/workflow change |
| Source ZIP artifact | Workflow added | Confirm ZIP upload in next successful run |
| 500-block Overworld height | Not implemented | Source audit and block-above-255 prototype |
| Bedrock at Y=0 | Design requirement | Verify after height prototype |
| Taller mountains/plateaus | Planned | Terrain prototype and seed tests |
| Ancient Redwood / Autumn Woodland / Misty Pine | Planned | First biome registration and natural generation |
| Blooming Meadow / Willow Marsh / Crystal Springs | Planned | Biome transition and feature tests |
| Alpine Glacier / Cloud Plateau / Wind-Carved Highlands | Planned | Height and surface-generation tests |
| Mega-cave networks | Planned | Chunk-safe cave carver/shape prototype |
| Lush Caves | Planned | Natural biome/region generation test |
| Sulfur Caves | Planned | Sulfur deposits, vents and resource-loop test |
| Lava Caves | Planned | Volcanic cave/contained lava test |
| Crystal Caverns | Planned | Crystal generation and resource use |
| Ice Caves | Planned; related winter design exists in IceUpdate | Integrate/adapt and test in fresh worlds |
| Fungal Caves | Planned | Cave ecology and vegetation test |
| Flooded Caves | Planned | Fluid containment and chunk-border test |
| Fossil Chambers / Deep Stone Halls | Planned | Rare structure/feature test |
| Winter surface biomes | Planned | First cold biome generation test |
| Winter structures | Planned | Structure placement, loot and server test |
| Nether new biomes | Planned | Ashen Wastes prototype first |
| Nether terrain/caves | Planned | Lava and basalt generation tests |
| Nether structures | Planned | Placement, loot and portal compatibility test |
| Wider End island layout | Planned | End island scale/spacing prototype |
| Purple Alien Jungle | Planned | End biome and plant generation test |
| Cold End | Planned | End biome and ecosystem test |
| Dead Forest | Planned | Biome palette and vegetation test |
| Crystal Barrens / Chorus Wetlands / Void Gardens | Planned | Biome and resource generation tests |
| End island interior caves | Planned | Cave generation inside large islands |
| End Ruins / Observatories / Void Citadel | Planned | Structure, loot and progression tests |
| End Shards / Void Totem / potions | Planned | Item logic and safe-destination tests |
| Phantom spawn relocation | Planned | Configurable spawn tests |
| Stronghold redesign | Planned | Structure connectivity and portal-room test |
| Block/material catalogue | Design added | Select first block families for registration |
| Deepslate and stone variants | Planned | Register base blocks, variants, models, loot and recipes |
| Lush Cave blocks | Planned | Moss, roots, vines, glowshrooms and natural placement |
| Ice/Froststone and Ice Spikes | Planned | Ice block family, spike features and cold-biome placement |
| Sulfur/volcanic materials | Planned | Ore drops, vents, processing and cave placement |
| Crystal/fungal/fossil materials | Planned | Block families, resources and cave generation |
| Nether material families | Planned | Ashstone, Emberwood, Soulglass, Caldera and Mire sets |
| End material families | Planned | Alien wood/soil, Deadwood, lilac stone and End crystal sets |
| Crafting/stonecutting/smelting recipes | Design added | Validate 1.16.1 recipes after block registration |
| Functional workstations | Concept only | Define GUI, block entity and recipe behavior before coding |

## Status vocabulary

- **Planned:** described in the feature specification.
- **Source written:** code exists but has not passed CI.
- **Build verified:** GitHub Actions completed compile/reobfuscation successfully.
- **In-game tested:** tested on the locked target version with results recorded.
- **Complete:** acceptance criteria pass, including save/reload and dedicated-server tests where relevant.

The initial green build verifies only the starter Forge project. It does not prove any of the planned biomes, caves, structures or height changes work in Minecraft.
