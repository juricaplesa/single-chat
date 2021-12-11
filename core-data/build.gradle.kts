apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "api"(Androidx.room)
    "kapt"(Androidx.roomCompiler)
}