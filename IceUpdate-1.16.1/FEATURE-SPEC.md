# Ice Update / Winter Update — Feature Specification

## Target

- Minecraft 1.16.1
- Forge 32.0.108
- Java 8 (JDK 1.8.0_202 compatible)
- MCP snapshot mappings `20200820-1.16.1`
- Mod ID: `iceupdate`

This backports the requested winter-update experience to 1.16.1. Later-version mechanics must be adapted to this version; native powder snow and underground biome support are not available in vanilla 1.16.1, so those require documented substitutes.

## Mobs

### Frostbite
- Frozen zombie variant spawning in cold surface biomes and Ice Caves.
- Throws Ice Balls that apply Freezing.
- Powder-snow immunity and Husk/Drowned conversion require 1.16.1-compatible substitutes.

### Ice Golem
- Winter golem with cold-combat interactions and fire vulnerability.
- Spawn egg exists in the supplied source; natural/build spawning needs verification.

### Iceologer / Chillager
- Hostile illager-style mini-boss that summons and throws ice chunks.
- Impacts should damage, slow and build up Freezing.
- Intended to guard the Iceologer Castle.
- Snowy raid integration and a localized blizzard should apply Freezing, with fire/campfires/lava acting as heat sources.

### Frost Sulfur Cube — Cold archetype
- Distinct cube mob with a Cold archetype activated by Blue Ice.
- Gains fast sliding and floats in liquids.
- When it begins moving while grounded, it freezes eligible source water underneath/around its path, provided there is air above the water.
- It must not freeze water while stationary or airborne.

### Penguins
- Passive ambient mob in snowy/frozen biomes.
- Waddling, swimming and idle behavior; interaction/nearby sliding provides a momentum boost on ice or snow.

### Snowy villagers
- Snowy variant appearance for villagers and zombie villagers inside Ice Caves, adapted to 1.16.1.

## Underground and structures

### Ice Caves
- Rare underground caverns beneath frozen surface biomes.
- Ice/calcite shell, crystals, icicles, pools and Brittle Ice.
- 1.16.1 has no native underground biome system; the current source uses a generation/placement approximation.

### Iceologer Castle / Temple
- High-elevation structure in snowy mountain / ice-spikes areas, intended to align above a rare Ice Cave.
- Packed ice, blue ice, chiseled ice/brick and snow-block architecture.
- Guarded by Iceologers, with winter loot chests.
- Cartographers should sell Ice Explorer Maps.

### Igloos
- Expanded igloo variants and basement layouts.
- Randomized brewing setups, caged villagers and winter loot.
- Hyper Potions music disc discovery in igloo basements.

## Blocks and decorative sets

- Ice Crystals: low-light source placeable on floor, wall and ceiling.
- Icicles: ceiling hazards; nearby heat sources can trigger detachment and falling damage.
- Brittle / Thin Ice: fragile ice over frozen lakes, rivers and cave pools; configured entity movement/weight breaks it.
- Calcite set: bricks, slabs, stairs and pillars.
- Packed Ice Brick set: bricks, slabs, stairs, walls and chiseled blocks.
- Snow Brick set: bricks, slabs, stairs and walls; non-melting and shovel-harvested.

## Items, effects, enchantments and audio

- Ice Ball item/projectile and Frostbite drops.
- Freezing status effect, Potion of Freezing and Arrow of Freezing.
- Freezing bow enchantment: cumulative cold meter, slow movement/attack speed and cold damage over time.
- Freezing Protection armor enchantment: reduces cold buildup from blizzards, Iceologer attacks and powder snow substitutes.
- Totem of Keeping: rare Iceologer reward that preserves inventory/XP on death, with configurable destination behavior.
- Hyper Potions disc, chest-over-jukebox playlist support, and ice sound updates for frozen oceans/rivers.

## Engineering rules

- Preserve the exact Minecraft/Forge/Java/mappings target.
- Verify APIs against Forge 32.0.108 / 1.16.1 mappings; do not upgrade versions to hide errors.
- Track each feature as source-written, CI-build-verified or in-game-tested.
- Test generation in newly generated chunks / a new world; old chunks will not regenerate.
