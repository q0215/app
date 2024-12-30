import com.google.protobuf.gradle.id

plugins {
  id("org.springframework.boot") version "3.4.1"
  id("io.spring.dependency-management") version "1.1.7"
  id("com.google.protobuf") version "0.9.4"
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
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
  implementation("org.springframework.boot:spring-boot-starter-web")
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  // https://mvnrepository.com/artifact/net.devh/grpc-spring-boot-starter
  implementation("net.devh:grpc-spring-boot-starter:3.1.0.RELEASE")
  // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
  compileOnly("javax.annotation:javax.annotation-api:1.3.2") // for @javax.annotation.Generated
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  // Prevent vulnerabilities
  // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-bom
  implementation(platform("com.google.protobuf:protobuf-bom:4.29.2"))
  // https://mvnrepository.com/artifact/io.grpc/grpc-bom
  implementation(platform("io.grpc:grpc-bom:1.69.0"))
}

protobuf {
  protoc {
    artifact = "com.google.protobuf:protoc:4.29.2"
  }
  plugins {
    id("grpc") {
      artifact = "io.grpc:protoc-gen-grpc-java:1.69.0"
    }
  }
  generateProtoTasks {
    all().forEach {
      it.plugins {
        id("grpc")
      }
    }
  }
}

tasks {
  test {
    useJUnitPlatform()
  }
  bootBuildImage {
    imagePlatform.set("linux/amd64")
    // TODO change run image
    //runImage.set("")
  }
}
