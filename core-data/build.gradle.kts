apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Module.core))
    "implementation"(Androidx.room)
    "implementation"(Androidx.roomKtx)
    "kapt"(Androidx.roomCompiler)
}