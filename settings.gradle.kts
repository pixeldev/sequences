pluginManagement {
  includeBuild("build-logic")
}

rootProject.name = "sequences"

sequenceOf("api", "base").forEach {
  include("${rootProject.name}-$it")
  project(":${rootProject.name}-$it").projectDir = file(it)
}
