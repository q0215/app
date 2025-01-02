import com.google.protobuf.gradle.id

plugins {
  java
  id("com.google.protobuf") version "0.9.4"
}

group = "com.github.q0215"
version = "0.0.0"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  // BOMs
  // https://mvnrepository.com/artifact/io.grpc/grpc-bom
  implementation(platform("io.grpc:grpc-bom:1.69.0"))
  // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-bom
  implementation(platform("com.google.protobuf:protobuf-bom:4.29.2"))

  // Direct dependencies
  // https://mvnrepository.com/artifact/com.google.protobuf/grpc-protobuf
  implementation("io.grpc:grpc-protobuf")
  // https://mvnrepository.com/artifact/com.google.protobuf/grpc-stub
  implementation("io.grpc:grpc-stub")
  // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java
  implementation("com.google.protobuf:protobuf-java")

  // Compile-only dependencies
  // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
  compileOnly("javax.annotation:javax.annotation-api:1.3.2") // for @javax.annotation.Generated
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
