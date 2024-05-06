import org.gradle.configurationcache.extensions.capitalized
import java.util.*

plugins {
  id("project.common-conventions")
  id("com.github.johnrengelman.shadow") version "8.1.1"
  id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

dependencies {
  implementation(project(":${rootProject.name}-api"))
}

bukkit {
  val projectName = rootProject.name.split("-").joinToString("") { it.capitalized() }
  val pluginName = "Revenge$projectName"
  name = pluginName
  apiVersion = "1.20"
  main = "es.revengenetwork.${projectName.lowercase(Locale.ROOT)}.${pluginName}Plugin"
  description = "Revenge $projectName plugin."
  authors = listOf("YOUR USERNAME HERE")
  depend = listOf("RevengeDevs")
}

tasks {
  shadowJar {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")
  }
}
