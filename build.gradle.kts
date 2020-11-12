import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
//    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}

group = "com.fatimacarneiro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.1")

    implementation("org.springframework.boot:spring-boot-starter-data-rest")
//    implementation("org.apache.kafka:kafka-streams")
//    implementation("org.springframework.kafka:spring-kafka")

    implementation("mysql:mysql-connector-java:6.0.6")

    val kotlinVersion = "1.4.10"
    implementation(kotlin("gradle-plugin", version = kotlinVersion))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

    implementation ("org.apache.kafka:kafka-clients:2.0.0")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.9.6")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.6")

    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.2.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
