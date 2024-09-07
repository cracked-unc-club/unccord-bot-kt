plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
    application
}

group = "com.beradeep"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://repo.kord.dev/snapshots")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("dev.kord:kord-core:0.14.0")
    implementation("org.slf4j:slf4j-simple:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.beradeep.MainKt")
}

tasks.jar {
    archiveFileName.set("unccord-kt.jar")
    manifest {
        attributes["Main-Class"] = "com.beradeep.MainKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

kotlin {
    jvmToolchain(17)
}