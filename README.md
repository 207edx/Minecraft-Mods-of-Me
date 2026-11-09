# Minecraft Mods of Me

AstroBackport 2.0.0 targets **Minecraft 1.16.1 / Forge 32.0.108**.

## Build requirements
- JDK 8 (the project intentionally rejects newer Java versions)
- Gradle 4.10.3
- ForgeGradle 3.0.197 from the Forge Maven

## Build
Put the original source archive at the repository root as `Mod.zip`. The GitHub Actions workflow will validate and extract it, run `gradle --no-daemon clean build` (including the project's `reobfJar` task), and publish the resulting JAR as a downloadable workflow artifact.

See the Actions tab for compiler output and build status.
