buildscript {
    val androidGradlePluginVersion by extra { Versions.gradleBuildTools }
    val kotlinVersion by extra { Versions.kotlin }

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradlePluginVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}