plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Module.core))
    implementation(project(Module.coreData))
    implementation(project(Module.userData))
    implementation(project(Module.messageData))
    implementation(project(Module.messageDomain))
    implementation(project(Module.messageListUi))

    implementation(Androidx.coreKtx)
    implementation(Androidx.appcompat)
    implementation(Androidx.constraintLayout)

    implementation(Google.material)

}