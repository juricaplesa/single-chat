apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(Module.core))
}