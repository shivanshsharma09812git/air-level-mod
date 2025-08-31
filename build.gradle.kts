plugins {
    id("fabric-loom") version "1.7.4"
    id("java")
}

group = "com.aircul"              // change if you want
version = "1.0.0+mc1.21.4"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

repositories {
    maven("https://maven.fabricmc.net/")
    mavenCentral()
}

dependencies {
    // Target Minecraft 1.21.4
    minecraft("com.mojang:minecraft:1.21.4")

    // Use official Mojang mappings so you don't have to chase Yarn build numbers
    mappings(loom.officialMojangMappings())

    // Fabric loader only (NO Fabric API)
    modImplementation("net.fabricmc:fabric-loader:0.16.10")
}

// name the output nicely
tasks.jar {
    archiveBaseName.set("air-cull")
    archiveVersion.set(version.toString())
}

// ensure a remapped, game-ready jar is produced on build
tasks.named("build") {
    dependsOn("remapJar")
}

// If your fabric.mod.json contains ${version}, expand it (safe if the file exists)
tasks.processResources {
    val props = mapOf("version" to project.version)
    filesMatching("fabric.mod.json") {
        expand(props)
    }
}
