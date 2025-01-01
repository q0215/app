plugins {
  id("org.springframework.boot") version "3.4.1"
  id("io.spring.dependency-management") version "1.1.7"
  kotlin("jvm") version "2.1.0"
  kotlin("plugin.spring") version "2.1.0"
}

group = "com.github.q0215"
version = "0.0.0"

kotlin {
  jvmToolchain(21)
}

repositories {
  mavenCentral()
}

dependencies {
  // Submodules
  implementation(project(":proto"))

  // Direct dependencies
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
  implementation("org.springframework.boot:spring-boot-starter-web")
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  // https://mvnrepository.com/artifact/net.devh/grpc-spring-boot-starter
  implementation("net.devh:grpc-spring-boot-starter:3.1.0.RELEASE")

  // Test dependencies
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
  test {
    useJUnitPlatform()
  }
  bootBuildImage {
    imagePlatform.set("linux/amd64")
  }
}
