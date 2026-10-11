import kr.co.taek.dev.build.JDK_VERSION
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JDK_VERSION
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findLibrary("kotlin-logging").get())
    testImplementation(libs.findLibrary("kotest-assertions-core").get())
    testImplementation(libs.findLibrary("kotest-runner-junit5").get())
}

ktlint {
    version.set("1.2.1")
    filter {
        exclude {
            it.file.path.startsWith(project.layout.buildDirectory.get().dir("generated").toString())
        }
    }
}
