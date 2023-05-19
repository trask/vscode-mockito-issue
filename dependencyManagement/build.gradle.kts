plugins {
  `java-platform`
}

javaPlatform {
  allowDependencies()
}

dependencies {
  api(enforcedPlatform("org.junit:junit-bom:5.9.3"))
  api(enforcedPlatform("org.mockito:mockito-bom:5.3.1"))
}
