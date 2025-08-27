plugins {
    id("fabric-loom") version "1.2.10"
    id("java")
}

val minecraftVersion = "1.21.4"
val loaderVersion = "0.16.10"
val fabricApiVersion = "0.116.2+1.21.4"

group = "com.aircul"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.fabricmc.net/") }
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:1.21.4+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")
    implementation("org.spongepowered:mixin:0.8.5")
}

loom {
    runs {
        create("client") {
            client()
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
