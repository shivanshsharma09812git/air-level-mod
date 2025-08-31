plugins {
    id("fabric-loom") version "1.7.4"
    id("java")

}

group = "com.aircul" // change if you want
version = "1.0.0"

java {
@@ -20,35 +19,23 @@ repositories {
}

dependencies {
    // Minecraft + Yarn mappings for 1.21.4
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.1:v2")

    // Fabric Loader + API (latest as of now)
    modImplementation("net.fabricmc:fabric-loader:0.16.10")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.111.0+1.21.4")
}
