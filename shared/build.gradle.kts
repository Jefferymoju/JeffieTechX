plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = "com.jeffery.jeffietechx"
version = "1.0-SNAPSHOT"

kotlin {
    js(IR) { browser() }
    jvm()

    @Suppress("UNUSED_VARIABLE") // Suppress spurious warnings about sourceset variables not being used
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
            }
        }
        val jvmMain by getting {
            dependencies {}
        }
    }
}
