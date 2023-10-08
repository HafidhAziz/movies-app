/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */

object Versions {
    const val kotlin = "1.9.0"
    const val appCompat = "1.6.0"
    const val materialDesign = "1.9.0"
    const val constraintLayout = "2.1.4"
    const val hilt = "2.44"
    const val coroutines = "1.6.0"
    const val paging = "3.1.1"
    const val retrofit = "2.9.0"
    const val navigation = "2.6.0"
    const val room = "2.5.2"
    const val glide = "4.16.0"
    const val test = "4.13.2"
    const val androidTest = "1.1.5"
    const val espresso = "3.5.1"
}

object Libraries {
    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Paging
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val pagingKtx = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val pagingCommon = "androidx.paging:paging-common:${Versions.paging}"

    // Navigation
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // Constraint Layout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object AndroidLibraries {

    const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlin}"
    const val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.materialDesign}"
    const val test = "junit:junit:${Versions.test}"
    const val androidTest = "androidx.test.ext:junit:${Versions.androidTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}