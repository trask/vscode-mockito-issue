pluginManagement {
  plugins {
    id("com.github.ben-manes.versions") version "0.46.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.gradle.enterprise") version "3.13.2"
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
  }
}

plugins {
  id("com.gradle.enterprise")
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    maven {
      url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    mavenLocal()
  }
}

val isCI = System.getenv("CI") != null
val skipBuildscan = System.getenv("SKIP_BUILDSCAN").toBoolean()
gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"

    if (isCI && !skipBuildscan) {
      publishAlways()
      tag("CI")
    }
  }
}

rootProject.name = "opentelemetry-java-contrib"

include(":dependencyManagement")
include(":resource-providers")
