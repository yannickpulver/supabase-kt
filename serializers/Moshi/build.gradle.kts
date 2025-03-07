plugins {
    id(libs.plugins.kotlin.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
}

description = "Extends supabase-kt with a Moshi Serializer"

repositories {
    mavenCentral()
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    defaultConfig()
    configuredAndroidTarget()
    configuredJvmTarget()
    sourceSets {
        val commonMain by getting {
            dependencies {
                addModules(SupabaseModule.SUPABASE)
                implementation(libs.kotlin.reflect)
                implementation(libs.bundles.moshi)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.bundles.testing)
                implementation(project(":test-common"))
            }
        }
    }
}

configureLibraryAndroidTarget()