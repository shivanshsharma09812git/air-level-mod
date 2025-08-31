plugins {
    id("fabric-loom") version "1.7.4" // stable-ish for 1.21.x
    java
    `maven-publish`
}

group = "com.example.aircull"

version = "1.0.0"

java {
@@ -14,17 +14,41 @@ java {
    withSourcesJar()
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.7")
    // Optional: include Fabric API for 1.21.4 — uncomment if you want it.
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.111.0+1.21.4")
}

/*
 * Ensure a jar is always created and named predictably.
 * Loom will also produce remapped artifacts, but this ensures
 * a plain jar is available under build/libs/
 */
tasks.jar {
    archiveBaseName.set("air-cull")
    archiveVersion.set(version.toString())
    // include compiled resources, if any
    from(sourceSets.main.get().output)
}

/*
 * If Loom's remap task is present, ensure build depends on it so
 * the remapped artifact is produced by default as part of build.
 */
tasks.named("build") {
    // Try to wire remapJar if it exists (works with Loom)
    doFirst {
        val remapTask = tasks.findByName("remapJar")
        if (remapTask != null) {
            dependsOn(remapTask)
        }
    }
}
