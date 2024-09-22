import org.apache.tools.ant.util.JavaEnvUtils.VERSION_1_8

plugins {
    alias(libs.plugins.android.application)
//    id("com.android.application")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.accelify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.accelify"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.appcheck.debug)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")

    // Also add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:21.2.0")


    implementation("androidx.cardview:cardview:1.0.0")

    implementation ("com.google.firebase:firebase-storage:20.0.0")

    implementation("com.google.firebase:firebase-appcheck")

    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))




        // Add Firebase App Check Play Integrity
        implementation ("com.google.firebase:firebase-appcheck-playintegrity:16.0.0")

        // Other Firebase dependencies...
//        implementation ("com.google.firebase:firebase-storage:20.2.1")
//        implementation ("com.google.firebase:firebase-auth:21.1.0")
        implementation ("com.google.firebase:firebase-firestore:24.4.3")










//    implementation ("androidx.appcompat:appcompat:1.6.1")  // or latest version



}