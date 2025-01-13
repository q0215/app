buildscript {
  dependencies {
    // https://mvnrepository.com/artifact/org.flywaydb/flyway-database-postgresql
    classpath("org.flywaydb:flyway-database-postgresql:11.1.1")
    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    classpath("org.postgresql:postgresql:42.7.4")
  }
}

plugins {
  // https://mvnrepository.com/artifact/org.flywaydb/flyway-gradle-plugin
  id("org.flywaydb.flyway") version "11.1.1"
}

repositories {
  mavenCentral()
}

flyway {
  url = "jdbc:postgresql://" + System.getenv("POSTGRESQL_HOST") + ":" + System.getenv("POSTGRESQL_PORT") + "/" + System.getenv("POSTGRESQL_DATABASE")
  user = System.getenv("POSTGRESQL_USERNAME")
  password = System.getenv("POSTGRESQL_PASSWORD")
}
