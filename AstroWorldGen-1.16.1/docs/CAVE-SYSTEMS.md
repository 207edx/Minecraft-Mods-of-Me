# Cave Systems and Underground Ecosystems

## Design goals

The underground should have distinct places to explore, not only bigger holes. Cave systems should vary in shape and scale, connect to surface geography, and generate consistently across chunk borders.

## Shared cave-generation rules

- Small tunnels, large passages, connected chambers and rare mega-caverns.
- Natural pillars, arches, shelves, stalactite-like formations and stone bridges.
- Underground rivers, lakes, waterfalls and flooded pockets.
- Openings, sinkholes and skylights in suitable terrain.
- Cave systems should follow the local geology and surface biome where appropriate.
- Avoid huge unsupported ceilings, abrupt fluid walls and caves that expose every underground structure.
- Reserve enough solid terrain for ores, dungeons and structures.
- Use deterministic seed-based placement and test the same seed repeatedly.

## Cave families

### 1. Lush Caves

**Visual identity:** green, living underground gardens.

- Moss floors, mossy stone, hanging roots and vine curtains.
- Glowshrooms, custom luminous plants and flowering cave growth.
- Root chambers, underground trees and large overgrown pockets.
- Clear pools, trickling streams and occasional waterfalls.
- Rare lush grottos with a large central tree or flower formation.
- Passive cave creatures and small pollinating creatures, subject to later mob design.
- Surface clues such as unusual tree roots or vegetation can hint at a lush cave below.

### 2. Sulfur Caves

**Visual identity:** yellow mineral seams, warm stone and steam.

- Sulfur ore/crystals, yellow mineral crusts and layered deposits.
- Steam vents, hot springs, mineral columns and small geysers.
- Rare sulfur chambers with concentrated deposits.
- Warm pools and stained stone formations.
- Steam particles and sound cues communicate nearby vents.
- Any gameplay hazard must be configurable and clearly signaled; do not make every sulfur cave a constant damage zone.
- Sulfur should have a defined crafting or processing use before the ore becomes common.

### 3. Lava Caves

**Visual identity:** enormous volcanic chambers and glowing lava rivers.

- Lava streams, falls and pools carved into volcanic rock.
- Basalt, blackstone, magma blocks, obsidian shelves and cooled lava surfaces.
- Ember crystals and rare volcanic ore pockets.
- Large chambers with islands, bridges and columns above lava.
- Heat-adapted mobs and nesting zones.
- Create safe observation ledges and readable paths; avoid filling every cave with lava.
- Rare volcanic shrines or abandoned mining outposts.

### 4. Crystal Caverns

**Visual identity:** mineral halls and resonant crystal clusters.

- Crystal geodes, tall crystal spires and wall clusters.
- Resonant shards and rare color variants.
- Reflective mineral pools and naturally lit chambers.
- Small crystal gardens and rare large crystal halls.
- Crystal resources must have uses beyond decorative blocks.

### 5. Ice Caves

**Visual identity:** frozen underground rivers and blue-white chambers.

- Packed/blue ice, frost crystals, icicles and frozen pools.
- Ice columns, frozen waterfalls and slippery ledges.
- Cold-region spawn tables and links to winter surface biomes.
- Rare Iceologer-related structures or hidden winter caches.
- Coordinate with IceUpdate without assuming its untested source already implements every planned feature.

### 6. Fungal Caves

**Visual identity:** fungal forests, spore carpets and giant mushrooms.

- Mycelium, giant mushroom clusters and unusual fungal pillars.
- Glowing spore plants and colored fungi.
- Damp basins and shallow water.
- Fungal nests and unique passive or hostile cave life.
- Separate the fungal ecosystem from the Lush Cave palette.

### 7. Flooded Caves

**Visual identity:** connected underground rivers and submerged routes.

- Underground streams, pools and submerged tunnels.
- Air pockets and dry ledges to keep exploration varied.
- Aquatic plants and cave-adapted aquatic creatures.
- Waterfalls connecting vertical chambers.
- Fluid placement must be chunk-safe and avoid uncontrolled flooding into unrelated structures.

### 8. Deep Stone Halls

**Visual identity:** huge quiet mineral spaces.

- Giant chambers, long stone galleries and natural arches.
- Ore bands, fossils and exposed mineral seams.
- Rare ancient ruins, abandoned camps and hidden libraries.
- Distinct stone palettes for geological depth zones.
- Avoid copying a later Minecraft version's named biome or implementation wholesale.

### 9. Fossil Chambers

**Visual identity:** rare archaeological discoveries.

- Large bone/fossil structures embedded into cavern walls.
- Fossil fragments, ancient plant imprints and rare loot.
- Small side chambers with clues or old expedition remains.
- Low placement frequency and no guaranteed valuable loot.

## Cave progression and resources

Each cave family must define:
- The blocks and resources that can be mined there.
- What those resources craft or unlock.
- How players recognize the cave type before entering.
- Mob behavior and spawn limits.
- Structure and loot rarity.
- How the feature behaves in new chunks, at chunk borders, and after reload.

## Suggested implementation order

1. Large cave-shape prototype with no new blocks.
2. Lush Cave biome/region prototype.
3. Crystal Cavern prototype.
4. Sulfur Cave blocks, vents and resource loop.
5. Lava Cave volcanic terrain.
6. Ice/Fungal/Flooded variants.
7. Rare structures and cave-specific mobs.

The first release should prioritize stable cave shapes and clear biome identity over a large number of unfinished cave types.
