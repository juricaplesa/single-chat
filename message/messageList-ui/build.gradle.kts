apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Module.components))
    "implementation"(project(Module.core))
}