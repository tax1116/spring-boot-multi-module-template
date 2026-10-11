import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("global-convention")
    kotlin("plugin.spring")
}

// spring-boot-convention은 dependency-management 플러그인(강제 적용 방식)을 사용하므로
// 버전 해석 방식이 다름에 유의. (Kotlin 등 독립적으로 버전을 올릴 경우 불일치 가능)
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(platform(libs.findLibrary("spring-boot-dependencies-bom").get()))
}
