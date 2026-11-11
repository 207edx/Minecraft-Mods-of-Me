# AstroWorldGen — Crafting and Processing Catalogue

## 0. First source-registered recipe batch

The current source tree includes **13 basic shaped recipes**:
- Cobbled Deepslate → Polished Deepslate.
- Polished Deepslate → Deepslate Bricks.
- Froststone → Froststone Bricks.
- Snow Blocks → Snow Bricks.
- Sulfur Stone → Sulfur Stone Bricks.
- Volcanic Rock → Volcanic Bricks.
- Compacted Ash → Ashstone Bricks.
- Lilac Stone → Lilac Stone Bricks.
- Sulfur → Sulfur Block.
- Frost Crystals → Frost Crystal Block.
- Crystal Shards → Cave Crystal Block.
- Ash → Compacted Ash.
- Ember Fragments → Emberstone.

These are starter recipes and need in-game recipe-book/unlock checks. The ore drop tables in this first prototype are deliberately simple; Fortune and Silk Touch support must be added and tested before treating the ore system as finished. Stonecutting, full stairs/slabs/walls, smelting/blasting progression and workstation recipes remain planned.

## 1. Recipe rules

- All recipes must use the Minecraft 1.16.1 recipe format and be validated by loading the game.
- Every recipe must use registered item/block IDs and a sensible progression cost.
- Use shaped recipes for recognizable building patterns, shapeless recipes for simple conversions and stonecutting for block-shape variants.
- Use smelting or blasting only when the material logically supports heat processing.
- Natural-only world blocks must be marked as such; do not invent a cheap crafting recipe for a rare biome feature.
- Recipe IDs should be namespaced under `astroworldgen:`.
- Include recipe advancement/unlock behavior using the expected 1.16.1 data format.
- Keep loot tables separate from crafting recipes.

## 2. Standard building-family recipes

Use familiar vanilla-style patterns, adjusted where the material balance requires it.

| Output family | Proposed method |
|---|---|
| Polished block | 4 matching rough blocks in a 2x2 pattern, when polishing is a real conversion |
| Bricks | 4 cut/polished material blocks in a 2x2 pattern |
| Chiseled block | 2 matching slabs vertically, if the material has a distinct chiseled texture |
| Stairs | 6 matching blocks in the standard stair pattern |
| Slab | 3 matching blocks in a row |
| Wall | 6 matching blocks in two rows |
| Fence | 4 planks + 2 sticks, using the vanilla fence pattern |
| Fence gate | 2 planks + 4 sticks, using the vanilla gate pattern |
| Door | 6 planks in two columns |
| Trapdoor | 6 planks in two rows |
| Pressure plate | 2 matching planks/stone blocks in a row |
| Button | 1 matching plank/stone block |
| Pillar | 2 matching blocks vertically, or stonecutter where suitable |

For each family, add stonecutter routes where they improve material efficiency and match vanilla behavior. Do not register duplicate recipes with conflicting outputs.

## 3. Deepslate and stone recipes

- Cobble-like stone → polished form → bricks/tiles, using documented processing steps.
- Deepslate bricks from polished deepslate or cut deepslate blocks.
- Cracked bricks/tiles by smelting their normal block variant.
- Chiseled form from two matching slabs where suitable.
- Stairs, slabs and walls by crafting and stonecutting.
- Deepslate ore drops should follow their matching ore's fortune/silk-touch rules.
- Smeltable ores should have normal furnace and/or blast-furnace recipes where applicable.
- Do not make every ore smelt directly into an ingot if the intended drop is a raw material.

## 4. Lush Cave recipes

- Moss carpet from lush moss using a compact, vanilla-like conversion.
- Mossy stone/brick variants from their base blocks plus moss where balanced.
- Rooted cave soil is primarily natural; a small conversion recipe may be added only if players need renewable building access.
- Glowshroom blocks should be harvested with the appropriate tool/condition; do not allow infinite high-value drops from one decorative block.
- Cave flowers, hanging roots and vines are primarily collected from natural growth.
- Optional decorative glowmoss block may be crafted from collected glowmoss, but light output must remain balanced.
- No recipe should allow a single common item to mass-produce rare cave plants without exploration.

## 5. Ice and snow recipes

- Froststone → polished froststone → froststone bricks.
- Froststone bricks, stairs, slabs, walls and chiseled forms follow the stone-family rules.
- Frost crystals can be compacted into a frost crystal block (proposed 9-to-1 storage conversion); reverse crafting returns 9 shards only if item economics require it.
- Snow bricks from compacted snow or snow blocks; intended building form is non-melting.
- Ice bricks from the stable custom frost ice, not vanilla ice unless the recipe deliberately consumes the original.
- Ice spike structures are natural generation and have no crafting recipe.
- Icicles and natural frost crystals are harvested as their own drops where appropriate.
- Thin/cracked ice should not be craftable into a stable ice block unless a repair recipe is intentionally added.

## 6. Sulfur and volcanic processing

Proposed resource route:
1. Mine sulfur ore with the intended tool.
2. Obtain sulfur material, respecting Fortune and Silk Touch.
3. Compact sulfur into a raw sulfur storage block.
4. Process raw sulfur using a furnace/blast furnace or Geology Workbench only after the processing mechanic is chosen.
5. Use refined sulfur in sulfur stone variants, decorative blocks or future utility recipes.

Additional proposals:
- Sulfur stone bricks from cut sulfur stone.
- Cracked sulfur bricks by smelting normal sulfur bricks.
- Ember fragments compact into an ember crystal/fragment block.
- Ash can be compacted into ash blocks and processed into ash bricks.
- Volcanic rock can be polished/cut into decorative forms.
- Obsidian/blackstone/basalt families should respect vanilla 1.16.1 recipes; custom recipes should add convenience or new variants rather than replace the vanilla ones.

No explosive or harmful real-world use is implied; sulfur is a fictional Minecraft crafting material.

## 7. Crystal and mineral recipes

- Matching crystal shards → matching crystal storage block.
- Crystal blocks → cut/polished crystal bricks or decorative pillars.
- Crystal clusters are primarily natural growth and should not be mass-crafted from common shards.
- Resonant crystal recipes should be held until the Crystal Resonator behavior is designed.
- Glass-like crystal panes can be added after collision, transparency and lighting are verified.

## 8. Fungal, fossil and flooded-cave recipes

- Mushroom stems/caps primarily form natural structures.
- Fungal bricks from compacted fungal material only if the block is stable and not a high-value resource.
- Fossil fragments may be compacted into a large bone/fossil block.
- Fossil stone bricks and chiseled fossil forms use normal stone-family patterns.
- Waterworn stone is a stonecutter/decorative conversion from waterworn base rock.
- Cave reeds, vines and submerged roots are collected from natural growth rather than mass-produced.

## 9. Nether material recipes

- Emberwood logs → planks using a standard wood conversion, plus the normal matching wood family.
- Ashstone → polished ashstone → ashstone bricks and decorative variants.
- Soulglass shards → soulglass blocks and panes only if transparency behavior is implemented.
- Crimson Mire mud → compacted mud/brick forms with stairs, slabs and walls.
- Caldera rock → polished caldera rock and bricks.
- Cracked Nether bricks/stone variants by smelting the uncracked family.
- Nether ores/resources need a clear purpose and balanced processing route.

## 10. End material and progression recipes

### Building materials
- Alien logs → alien planks and the full wood family.
- Deadwood logs → deadwood planks and the full wood family.
- Lilac stone → polished/lilac bricks, chiseled, stairs, slabs and walls.
- End crystal shards → decorative crystal blocks where appropriate.
- Chorus wetland roots/reeds are primarily natural decorative materials.

### Progression
- End Shard-enhanced Totem: a rare, intentional recipe or altar-based upgrade, not a cheap repeatable crafting recipe.
- Potion of Returning: brewing route using End Shards; exact ingredient sequence must be tested against 1.16.1 brewing mechanics.
- Levitation potion using Shulker Shells is a proposal; exact recipe and balance remain open.
- Void Totem should be a rare loot/progression reward from the hard End structure, not an easy crafting recipe.

## 11. Functional workstation recipes

If these blocks are approved for implementation:
- Geology Workbench: modest stone/iron/tool component recipe.
- Crystal Resonator: crystal materials plus redstone and a durable base.
- Volcanic Forge: volcanic rock/obsidian plus a heat source component.
- End Shard Altar: structure-built or rare-material recipe; keep progression gated.
- Workstations must have a clear GUI, valid input/output handling, server-side recipe checks and proper block entity save/load.

## 12. Recipe validation checklist

For every recipe:
- Correct 1.16.1 JSON schema and serializer.
- All ingredient/result IDs exist.
- Correct count and damage/NBT behavior where relevant.
- No duplicate recipe IDs.
- No unintended infinite loops or free material duplication.
- Unlock conditions are reachable.
- Recipe works in the intended station.
- Recipe output appears in recipe book where appropriate.
- Test in a fresh development world and dedicated server.
