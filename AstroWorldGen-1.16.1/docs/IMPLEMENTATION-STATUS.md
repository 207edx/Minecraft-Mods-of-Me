# Implementation Status

Target: Minecraft 1.16.1 / Forge 32.0.108 / Java 8 / Gradle 4.10.3.

| Feature | Status | Notes |
|---|---|---|
| 32 original base blocks, 6 resource items and 13 recipes | Existing source | Retained |
| Original material texture set | Existing source | Custom pixel-art textures |
| Cherry Grove biome prototype | Source added | Registered for normal Overworld biome selection |
| Pale Forest biome prototype | Source added | Registered for normal Overworld biome selection |
| Frozen Pine Valley biome prototype | Source added | Snowy surface settings; penguin spawn region |
| Volcanic Badlands biome prototype | Source added | Dark stone/basalt surface settings |
| Crystal Springs biome prototype | Source added | Mineral water palette |
| Additional Overworld cave carver | Source added | Added to new chunk generation; increases tunnel/room attempts |
| Additional canyon carver | Source added | Low-frequency ravines in new chunks |
| Climate-based cave/geology deposits | Source added | Frost, sulfur, volcanic, lush, crystal and fossil blocks |
| Nether material deposits | Source added | Caldera rock, ash, emberstone and soulglass in newly generated Nether chunks |
| Chunk-load cave mutation pass | Disabled | Removed from mod startup; existing chunks are not edited on load |
| Brittle Ice block | Source added | Breaks after a living entity walks over it |
| Ice Crystal block | Source added | Directional attachment; emits light |
| Icicle block | Source added | Falls when nearby heat is detected |
| Penguin entity | Source added | Wander, swim, fish temptation, ice sliding |
| Penguin model and texture | Source added | Adapted from supplied IceUpdate source |
| Penguin spawn egg and natural spawning | Source added | Cold/icy biomes |
| Custom cherry/pale tree species and vegetation | Not implemented | Biome prototypes need more visual identity |
| Large custom cave chambers, underground rivers and cave structures | Not implemented | Current cave system uses vanilla 1.16.1 carvers + themed deposits |
| True underground biome volumes | Not available in 1.16.1 | Use carvers and biome-specific feature placement |
| Nether/End biome expansion | Not implemented | Future milestone |
| Y=500 build-height engine | Not implemented | Needs engine work in chunk storage, heightmaps, lighting, persistence, networking, collision and rendering |
| Existing-save compatibility | Not yet in-game tested | Worldgen now runs during new-chunk generation instead of on chunk load |
| Dedicated server synchronization | Not yet in-game tested | Test matching client/server JARs |

## Release verification

1. GitHub Actions must pass Java 8 / Gradle 4.10.3 compilation and reobfuscation.
2. Launch Forge 32.0.108 and verify biomes, penguin model/texture and block models.
3. Create a fresh world and check cave frequency and every biome-specific deposit.
4. Explore new chunks in a copy of an existing world; confirm previously generated chunks remain unchanged.
5. Save, quit and reload the test world.
6. Test a dedicated server and client with the exact same JAR.

A green build does not replace in-game or save-compatibility testing.
