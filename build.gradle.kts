val koTestVersion: String by project

plugins {
    kotlin("jvm") version "2.0.21"
}

group = "aoc2024"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-assertions-core:$koTestVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$koTestVersion")
}

tasks.test {
    useJUnitPlatform()
}