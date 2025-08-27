pluginManagement {
    repositories {
        // required so Gradle can find the fabric-loom plugin
        maven("https://maven.fabricmc.net/")
        // default plugin portal (keeps compatibility)
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}
rootProject.name = "air-cull"
