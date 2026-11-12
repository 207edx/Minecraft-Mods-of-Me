# World Generation Catalogue

This catalogue records the intended biome families and surface-world direction. Names are working names and can be refined before implementation.

## Overworld — forests and green regions

| Working biome | Terrain and identity | Signature generation |
|---|---|---|
| Ancient Redwood Forest | Very tall old-growth forest, shaded floor and huge clearings | Giant redwood-style trees, fallen trunks, moss, ferns and rare hollow trunks |
| Autumn Woodland | Warm orange, amber and muted red woodland | Autumn canopy trees, leaf carpets, mushrooms and winding creeks |
| Misty Pine Taiga | Dense pine forests and foggy valleys | Tall pines, mossy boulders, cold streams and occasional clearings |
| Blooming Meadow | Wide flower-rich fields with gentle rolling terrain | Tall flowers, small groves, beehives, ponds and rare flower circles |
| Willow Marsh | Wet lowland with shallow water and twisting trees | Willow-like trees, reeds, lily cover, mud banks and small islets |
| Fungal Wetlands | Humid swamp-like region with oversized fungi | Giant mushrooms, glowing fungi, spore plants and shallow pools |
| Crystal Springs | Clear springs and mineral-rich rocky streams | Crystal clusters, bright pools, stone arches and rare geodes |

## Overworld — highlands and mountain regions

| Working biome | Terrain and identity | Signature generation |
|---|---|---|
| Wind-Carved Highlands | Exposed ridges, steep slopes and windswept rock | Thin trees, rock needles, cliff arches and high-altitude plants |
| Cloud Plateau | Broad high-elevation tablelands with dramatic edges | Waterfalls, isolated groves, highland lakes and rare ruins |
| Alpine Glacier | Snowy peaks, glaciers and ice-carved valleys | Crevasses, blue-ice formations, frozen waterfalls and snow caves |
| Highland Valley | Large elevated valleys between mountain chains | Meadows, rivers, pine groves and cliffside caverns |
| Shattered Badlands | Layered mesas, broken pillars and deep dry gullies | Terracotta spires, fossil pockets and exposed mineral bands |

## Overworld — drylands and coasts

| Working biome | Terrain and identity | Signature generation |
|---|---|---|
| Red Dune Desert | Wide dunes and sandstone ridges | Wind-carved arches, dry wells, buried ruins and desert plants |
| Salt Flats | Pale flat basin with mineral crusts | Salt-like decorative blocks, shallow mineral pools and rare pillars |
| Volcanic Badlands | Dark rock, ash slopes and old volcanic cones | Basalt-like columns, cooled lava, vents and obsidian pockets |
| Rocky Coast | Steep shores, sea cliffs and offshore stacks | Sea caves, arches, tide pools and coastal ruins |
| Far-Isle Archipelago | Small island chains with varied vegetation | Sea stacks, hidden coves, rare island structures and underwater entrances |

## Winter and cold regions

- Frozen Pine Valley: sheltered snowy forests with frozen streams.
- Glacial Highlands: high ice fields, crevasses and blue-ice cliffs.
- Snowdrift Basin: broad cold basin with deep snow formations and scattered trees.
- Frosted Redwood Grove: rare tall conifers in snowy terrain.
- Winter coast: frozen cliffs, ice shelves, sea caves and drifting ice formations.

Winter worldgen must coordinate with the standalone IceUpdate mod's planned entities and mechanics. This project focuses on terrain, biome placement and structures.

## Underground biome regions

The cave catalogue lives in CAVE-SYSTEMS.md. Underground regions should use a combination of cave shape, local blocks, vegetation, atmosphere, fluids, resources and spawn rules to create recognizable ecosystems.

## Biome design checklist

Every biome proposal must define:
1. Temperature/climate and elevation range.
2. Terrain height profile and transition neighbors.
3. Surface and subsurface blocks.
4. Trees, plants, rocks and decorative features.
5. Water/lava placement and local cave connections.
6. Passive, neutral and hostile spawn tables.
7. Structures and resource distribution.
8. Ambient sounds, particles, fog and visual identity.
9. Rarity and configuration behavior.
10. In-game seed tests across multiple neighboring chunks.

Do not implement every listed biome at once. Begin with one surface biome and one cave biome as controlled generation proofs, then expand.
