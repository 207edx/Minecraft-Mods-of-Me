# Development Setup

## Locked environment

- JDK 8 (the user's known setup uses JDK 1.8.0_202)
- Gradle 4.10.3
- Minecraft 1.16.1
- Forge 32.0.108
- MCP mappings `20200820-1.16.1`

Do not run this old ForgeGradle project on a newer Java runtime unless the build tooling is deliberately upgraded and compatibility is re-verified.

## Build on Windows

Open PowerShell in the `AstroWorldGen-1.16.1` project directory and select JDK 8:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_202"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
java -version
gradle --version
gradle --no-daemon clean build
```

Expected output folder:

```text
build\libs\
```

## GitHub Actions

The repository workflow builds this project independently and uploads the JAR as an artifact. Open the repository's **Actions** tab, select **AstroWorldGen Forge 1.16.1 Build**, and inspect the job log and artifact.

## In-game testing

1. Use a separate Forge 1.16.1 / 32.0.108 profile.
2. Install the produced JAR only after CI has built it.
3. Create a new disposable test world.
4. Record logs and screenshots for each worldgen feature.
5. Test save, quit, reload and (for height changes) a dedicated-server connection.

Do not use a valuable existing world for experimental height/section-format changes.
