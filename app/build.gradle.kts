plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdk)
    dataBinding.isEnabled = true

    defaultConfig {
        applicationId = "org.ymegane.android.cardanimationsample"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile("proguard-rules.pro")
        }
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:${Versions.androidxAppCompat}")
    implementation("androidx.cardview:cardview:${Versions.androidxCardView}")
    implementation("androidx.recyclerview:recyclerview:${Versions.androidxRecyclerView}")

    implementation("androidx.core:core-ktx:${Versions.androidxKtx}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.androidxConstraint}")
    testImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test:runner:${Versions.androidxTestRunner}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.androidxEspresso}")
}