plugins {
    id("org.jetbrains.intellij.platform") version "2.12.0"
    id("org.jetbrains.kotlin.jvm") version "2.1.21"
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    intellijPlatform {
        rider(providers.gradleProperty("platformVersion").get()) {
            useInstaller = false
        }
    }
}

intellijPlatform {
    pluginConfiguration {
        id = "com.quantum.qtn.icon"
        name = "Quantum QTN File Icon"
        version = providers.gradleProperty("pluginVersion").get()
        description = "Adds a custom icon for Photon Quantum .qtn files in Rider."
        vendor {
            name = "Quantum QTN"
        }
        ideaVersion {
            sinceBuild = "243"
        }
    }
}

tasks.named<Zip>("buildPlugin") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}