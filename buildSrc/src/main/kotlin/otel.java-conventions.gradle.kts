plugins {
  `java-library`
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}

tasks {
  withType<JavaCompile>().configureEach {
    with(options) {
      release.set(8)
    }
  }

  withType<Test>().configureEach {
    useJUnitPlatform()
  }
}

val dependencyManagement by configurations.creating {
  isCanBeConsumed = false
  isCanBeResolved = false
  isVisible = false
}

dependencies {
  dependencyManagement(platform(project(":dependencyManagement")))
  afterEvaluate {
    configurations.configureEach {
      if (isCanBeResolved && !isCanBeConsumed) {
        extendsFrom(dependencyManagement)
      }
    }
  }
}

testing {
  suites.withType(JvmTestSuite::class).configureEach {
    dependencies {
      implementation(project(project.path))

      implementation("org.junit.jupiter:junit-jupiter-api")
      implementation("org.junit.jupiter:junit-jupiter-params")
      implementation("org.mockito:mockito-core")
      implementation("org.mockito:mockito-junit-jupiter")

      runtimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
  }
}
