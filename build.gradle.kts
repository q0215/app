plugins {
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-gradle-plugin
  id("org.springframework.boot") version "3.4.1"
  // https://mvnrepository.com/artifact/io.spring.gradle/dependency-management-plugin
  id("io.spring.dependency-management") version "1.1.7"
  // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
  kotlin("jvm") version "2.1.0"
  // https://mvnrepository.com/artifact/org.jetbrains.kotlin.plugin.spring/org.jetbrains.kotlin.plugin.spring.gradle.plugin
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
  /*
  There is a vulnerability, and some IDEs may show warnings,
  but it can be ignored because it will be overridden by the version specified in the proto project.
  If you want to avoid this (though it may be redundant), specify BOMs.
   */
  // https://mvnrepository.com/artifact/net.devh/grpc-spring-boot-starter
  implementation("net.devh:grpc-spring-boot-starter:3.1.0.RELEASE")
  // https://mvnrepository.com/artifact/net.logstash.logback/logstash-logback-encoder
  implementation("net.logstash.logback:logstash-logback-encoder:8.0")
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  // Runtime dependencies
  // https://mvnrepository.com/artifact/org.postgresql/postgresql
  runtimeOnly("org.postgresql:postgresql:42.7.4")

  // Test dependencies
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  // https://mvnrepository.com/artifact/com.h2database/h2
  testImplementation("com.h2database:h2")
}

tasks {
  test {
    useJUnitPlatform()
  }
  bootBuildImage {
    imagePlatform.set("linux/amd64")
  }
}
