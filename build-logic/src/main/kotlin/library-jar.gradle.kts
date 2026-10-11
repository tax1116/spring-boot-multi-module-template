import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.named

tasks.named<Jar>("jar") {
    enabled = true
}
