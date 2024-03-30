plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include(
    "circuitbreaker-example",
    "chaos-monkey-example"
)
