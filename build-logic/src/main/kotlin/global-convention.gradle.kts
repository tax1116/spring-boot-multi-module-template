import kr.co.taek.dev.build.JDK_VERSION
import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    kotlin("jvm")
    id("lint-convention")
}

group = "kr.co.taek.dev"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(JDK_VERSION))
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findLibrary("kotlin-logging").get())
    testImplementation(libs.findLibrary("spring-boot-starter-test").get())
}

ktlint {
    filter {
        exclude {
            it.file.path.startsWith(project.layout.buildDirectory.get().dir("generated").toString())
        }
    }
}
