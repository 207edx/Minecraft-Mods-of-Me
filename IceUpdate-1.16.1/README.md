# Ice Update — Minecraft 1.16.1 Forge

A winter-update backport targeting **Minecraft 1.16.1**, **Forge 32.0.108**, **Java 8**, and snapshot mappings `20200820-1.16.1`.

## Source

The submitted Forge project (Java sources, Gradle config, resources manifest, resource generator and project docs) is preserved in [`source/IceUpdate-1.16.1-source.zip`](source/IceUpdate-1.16.1-source.zip). Extract it and open `IceUpdate/`.

## Build

The repository-level GitHub Actions workflow compiles the archive using Temurin Java 8 and Gradle 4.10.3, generates the resource assets, and uploads the reobfuscated JAR as the `iceupdate-forge-1.16.1` artifact. Expected JAR: `iceupdate-1.0.0.jar`.

## Verification

The supplied source had not been compiled or tested in Minecraft before this workflow was added. A green CI run verifies compilation/reobfuscation only; it does not prove all features work in-game. See `FEATURE-SPEC.md` and `IMPLEMENTATION-STATUS.md` for requested scope and honest status tracking.
