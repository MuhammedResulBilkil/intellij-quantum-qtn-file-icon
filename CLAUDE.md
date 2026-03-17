# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

- `./gradlew buildPlugin` — Build distributable zip (output: `build/distributions/`)
- `./gradlew runIde` — Launch sandbox Rider IDE with plugin pre-installed
- `./gradlew clean` — Clean build artifacts

No tests exist in this project.

## Architecture

JetBrains IntelliJ plugin that provides a custom file icon for Photon Quantum `.qtn` files. Built with IntelliJ Platform Gradle Plugin 2.12.0 on Kotlin/JVM 17.

**Extension point:** `iconProvider` registered with `order="first"` in `plugin.xml` — this gives it priority over other icon providers.

**Flow:** IntelliJ calls `QtnIconProvider.getIcon()` → checks if element is a `PsiFile` with `.qtn` extension → returns icon from `QtnIcons.QTN_FILE` (loaded via `IconLoader` from `/icons/qtn.png`).

Key files:
- `src/main/kotlin/com/quantum/qtn/QtnIconProvider.kt` — IconProvider implementation
- `src/main/kotlin/com/quantum/qtn/QtnIcons.kt` — Icon resource singleton
- `src/main/resources/META-INF/plugin.xml` — Plugin descriptor
- `src/main/resources/icons/qtn.png` — Icon asset

## Platform Target

- **IDE:** Rider (platformType=RD), version 2024.3+
- **sinceBuild:** 243
- **Java:** 17
- **Kotlin:** 2.1.21
- **Plugin ID:** `com.quantum.qtn.icon`
