import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.graalvm.buildtools.native") version "0.9.24"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    kotlin("plugin.jpa") version "1.9.0"
}

group = "com.hugomarques"
version = "0.0.1"
description = "Back para o projeto rinha backend 2023"

repositories {
    mavenCentral()
}

java {
    // This project uses Java 21 apis
    sourceCompatibility = JavaVersion.VERSION_20
    targetCompatibility = JavaVersion.VERSION_20
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        // Null-safety for Spring API in Kotlin
        freeCompilerArgs = listOf("-Xjsr305=strict")
        // Highest so far Java version supported by Kotlin
        jvmTarget = "20"
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.gatling.highcharts:gatling-charts-highcharts:3.9.5")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
