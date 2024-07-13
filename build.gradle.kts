import com.google.cloud.tools.jib.gradle.JibExtension

plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("com.google.cloud.tools.jib") version "3.4.3"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.mood"
base.archivesName = "backend"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<Jar>("jar") {
    enabled = false
}

configure<JibExtension> {
    from {
        image = "amazoncorretto:21-alpine"
    }

    to {
        tags = setOf("latest")
        image = "hongdae/mood-backend"
        auth {
            setCredHelper("docker")
        }
    }

    container {
        creationTime = "USE_CURRENT_TIMESTAMP"
        jvmFlags = listOf(
            "-XX:+UseContainerSupport",
            "-Dfile.encoding=UTF-8",
        )
        ports = listOf("8080")
    }
}
