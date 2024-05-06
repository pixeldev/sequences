rootProject.name = "sequences-build-logic"

dependencyResolutionManagement {
  versionCatalogs {
    register("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}
