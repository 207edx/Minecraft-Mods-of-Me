# Minecraft Mods of Me

This repository contains the AstroBackport 1.16.1 Forge source archive and its GitHub Actions build workflow.

## Target
- Minecraft 1.16.1
- Forge 32.0.108
- ForgeGradle 3.0.197
- Java 8
- Gradle 4.10.3

The `Mod.zip` archive is unpacked by GitHub Actions and compiled with `clean build`. The reobfuscated mod JAR is published as a workflow artifact after a successful build.

See the Actions tab for build status and downloadable artifacts.