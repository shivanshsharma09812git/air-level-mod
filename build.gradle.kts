plugins {
    id("fabric-loom") version "1.7.4"
    id("java")
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
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.7")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.111.0+1.21.4")
}

tasks.jar {
    archiveBaseName.set("air-level-mod")
    archiveVersion.set("1.0.0")
    from("LICENSE") {
        rename { "${it}_${archiveBaseName.get()}" }
    }
}
