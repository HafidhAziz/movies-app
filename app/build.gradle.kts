plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.trawlbens.hometest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.trawlbens.hometest"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/\"")
        buildConfigField("String", "SMALL_IMAGE_URL", "\"https://image.tmdb.org/t/p/w200\"")
        buildConfigField("String", "LARGE_IMAGE_URL", "\"https://image.tmdb.org/t/p/w500\"")
        buildConfigField("String", "ORIGINAL_IMAGE_URL", "\"https://image.tmdb.org/t/p/original\"")
        buildConfigField("String", "TMDB_AUTH", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YjAzNTQyNzVkNTIyOTI3OWU3NWJkZmJlNDlhNTlhOCIsInN1YiI6IjYwNDc3YTlhYzhhNWFjMDAzMDRjOGJjYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.YErzbYJOMwuWGJ8JhZLsHpvurjNY691UnHGSvqbW8c8\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(AndroidLibraries.kotlinCore)
    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.material)
    implementation(Libraries.constraintLayout)

    implementation(Libraries.room)
    kapt(Libraries.roomCompiler)

    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltAndroidCompiler)

    implementation(Libraries.navigation)
    implementation(Libraries.navigationUi)

    implementation(Libraries.pagingKtx)
    implementation(Libraries.pagingRuntime)
    implementation(Libraries.pagingCommon)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGsonConverter)

    implementation(Libraries.glide)

    testImplementation(AndroidLibraries.test)
    androidTestImplementation(AndroidLibraries.androidTest)
    androidTestImplementation(AndroidLibraries.espresso)

    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")
}