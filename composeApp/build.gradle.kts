import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    jvm()
    
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(compose.components.resources)
            implementation(project(":shared"))
            implementation(project(":day01"))
            implementation(project(":day02"))
            implementation(project(":day03"))
            implementation(project(":day04"))
            implementation(project(":day05"))
            implementation(project(":day06"))
            implementation(project(":day07"))
            implementation(project(":day08"))
            implementation(project(":day09"))
            implementation(project(":day10"))
            implementation(project(":day11"))
            implementation(project(":day12"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}


compose.desktop {
    application {
        mainClass = "com.rielk.advent.of.code25.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.rielk.advent.of.code25"
            packageVersion = "1.0.0"
        }
    }
}
