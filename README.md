# Minecraft Mods of Me

Build pipeline prepared for **AstroBackport 2.0.0**.

## Target
- Minecraft 1.16.1
- Forge 32.0.108
- ForgeGradle 3.0.197
- Java 8
- Gradle 4.10.3

## Build
Upload the supplied source archive as **`Mod.zip`** in the repository root. A push containing that file automatically starts the GitHub Actions workflow. It validates the archive, runs `gradle --no-daemon clean build`, and publishes the reobfuscated mod JAR as a downloadable Actions artifact.

The source project is expected at `AstroBackport-1.16.1-2.0.0/` inside the ZIP.
