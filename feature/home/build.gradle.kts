plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.polaroid.home"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "com.polaroid.home.presentation.TestAppJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation(project(":core:navigation"))

    //compose
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeCoil)

    //testing
    testImplementation(Dependencies.jUnitTest)
    androidTestImplementation(Dependencies.composeUiTest)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coreTesting)
    testImplementation(Dependencies.coroutinesTest)
    kaptAndroidTest(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTest)
    androidTestImplementation(Dependencies.jUnitRunner)
    debugImplementation(Dependencies.composeTooling)
    debugImplementation(Dependencies.composeManifest)

    //hilt
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    //gson
    implementation(Dependencies.gson)
}