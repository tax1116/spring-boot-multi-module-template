plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.spring.boot.gradle)
    implementation(libs.spring.dependency.management)
    implementation(libs.kotlin.gradle)
    implementation(libs.kotlin.allopen)
    implementation(libs.kotlin.noarg)
    implementation(libs.ktlint)
}
