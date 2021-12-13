apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Module.core))
    "implementation"(project(Module.coreData))
    "implementation"(project(Module.messageDomain))
}