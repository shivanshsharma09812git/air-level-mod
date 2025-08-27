plugins {
    id("fabric-loom") version "1.7-SNAPSHOT"
    id("maven-publish")
    java
}

group = "com.example"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.4")
    mappings("net.fabricmc:yarn:1.20.4+build.3:v2")
    modImplementation("net.fabricmc:fabric-loader:0.15.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.97.8+1.20.4")
}

tasks.jar {
    archiveBaseName.set("air-cull")
    archiveVersion.set(version.toString())
    from("LICENSE") {
        rename { "LICENSE_${project.name}" }
    }
}
