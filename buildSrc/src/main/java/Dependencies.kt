object Dependencies {
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"

    //compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val accompanistNavigation = "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanistNavigation}"
    const val composeCoil = "io.coil-kt:coil-compose:${Versions.composeCoil}"
    // testing
    const val jUnitTest = "junit:junit:${Versions.jUnitTest}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    // hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}
