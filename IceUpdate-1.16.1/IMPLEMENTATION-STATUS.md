# Implementation Status

**No feature is claimed as build-verified or in-game-tested yet.** The submitted source was an uncompiled prototype. GitHub Actions is being added as the first repeatable compile gate.

| Feature | Current status | Remaining work / verification |
|---|---|---|
| Frostbite | Source present | Compile and test spawn/projectile/effect; add 1.16.1 substitutes for powder snow immunity and Husk/Drowned conversions |
| Ice Golem | Source present | Compile and test AI, damage, spawn egg and natural/build spawning |
| Iceologer | Source present | Compile and test AI/projectile; castle-only spawn, raid integration, blizzard and rare Totem drop missing |
| Frost Sulfur Cube | Patched partial source | Blue Ice activates Cold archetype; grounded-moving-only water freezing added; verify float/slide and exact fluid rules in-game |
| Penguins | Missing | Entity, models/animations, biome spawn and momentum-slide behavior |
| Ice Caves | Prototype generation present | Validate rates, structures, chunk safety, pools and natural Brittle Ice in fresh worlds |
| Iceologer Castle | Missing | Structure placement, chest loot, guards and cave alignment |
| Ice Explorer Maps | Missing | Cartographer trade and target map |
| Igloo variants/basements | Missing | Structure variants, brewing/caged villagers and loot |
| Ice Crystals | Source present | Verify low light, placement/orientation and rendering |
| Icicles | Source present | Verify hanging support, heat detection, fall and damage |
| Brittle Ice | Source present | Verify weight/movement triggers and natural water placement |
| Calcite set | Source present | Verify states, recipes, loot and models |
| Packed Ice Brick set | Source present | Verify states, recipes, loot and models |
| Snow Brick set | Source present | Verify non-melting, shovel harvest, states and models |
| Ice Balls | Source present | Verify throw/collision/drops/recipes |
| Freezing effect/potion/arrow | Source present | Verify tick behavior, brewing, arrow and localization |
| Freezing enchantment | Missing | Implement enchantment and cumulative buildup |
| Freezing Protection | Missing | Implement armor enchantment/resistance |
| Totem of Keeping | Missing | Implement death-event inventory/XP persistence and config policy |
| Hyper Potions disc | Missing | Disc item, sound and igloo loot |
| Jukebox/audio | Missing | Chest playlist handling and ice sound overrides |
| Snowy villagers | Missing | Compatible appearance/variant behavior |
| Raid blizzard | Missing | Snowy raid integration, radius, heat-source mitigation |

A green CI job proves compilation/reobfuscation only. In-game testing must be recorded separately after launching Minecraft 1.16.1 Forge 32.0.108.
