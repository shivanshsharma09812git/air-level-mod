plugins {
    id("fabric-loom") version "1.7.4"
    java
    `maven-publish`
}

group = "com.aircul"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.1:v2")

    modImplementation("net.fabricmc:fabric-loader:0.16.10")
    // If you need Fabric API, uncomment and ensure correct version:
    // modImplementation("net.fabricmc.fabric-api:fabric-api:0.111.0+1.21.4")
}

tasks.jar {
    archiveBaseName.set("air-cull")
    archiveVersion.set(version.toString())
    from(sourceSets.main.get().output)
}

tasks.matching { it.name == "remapJar" }.configureEach {
    tasks.named("build") { dependsOn(this@configureEach) }
}

tasks.register("listArtifacts") {
    doLast {
        println("build/libs contents:")
        file("build/libs")?.listFiles()?.forEach { println(" - ${it.name}") }
    }
}
