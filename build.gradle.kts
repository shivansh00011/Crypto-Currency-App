buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.52")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false



    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false


}
