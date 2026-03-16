plugins {
    kotlin("jvm") version "2.2.21"
}

group = "org.gormad"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jna)
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}