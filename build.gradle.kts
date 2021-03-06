repositories {
  mavenCentral()
  maven("https://jitpack.io")
}

plugins {
  kotlin("jvm") version "1.4.30"
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

dependencies {
  implementation("com.github.ajalt.clikt:clikt:3.1.0")
  implementation("io.ktor:ktor-server-netty:1.5.1")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.0-M1")
  testImplementation("com.natpryce:hamkrest:1.8.0.1")
  testImplementation("io.mockk:mockk:1.10.6")
}

tasks.test {
  useJUnitPlatform()
}

tasks.compileKotlin {
  kotlinOptions.jvmTarget = "15"
}

tasks.jar {
  manifest {
    attributes("Main-Class" to "AppKt")
  }
}

tasks.shadowJar {
  archiveClassifier.set("")
  archiveVersion.set("")
  destinationDirectory.set(rootDir)
}