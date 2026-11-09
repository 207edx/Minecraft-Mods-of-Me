# Minecraft Mods of Me

AstroBackport source build for **Minecraft 1.16.1 / Forge 32.0.108**.

## Build target
- Java 8
- ForgeGradle 3.0.197
- Gradle 4.10.3
- Full original source archive, without removing gameplay features

The GitHub Actions workflow reassembles the original `Mod.zip`, validates it, runs `gradle --no-daemon clean build` (including the project's `reobfJar` task), and publishes the compiled JAR as an Actions artifact.

See **Actions → Build AstroBackport 1.16.1 Forge** for build logs and the JAR artifact.
