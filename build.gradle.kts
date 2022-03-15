
plugins {
    // Apply the scala Plugin to add support for Scala.
    scala
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/austral-ingsis/printscript-parser-common")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    // Use Scala 2.13 in our library project
    implementation("org.scala-lang:scala-library:2.13.6")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:30.1.1-jre")

    // Use Scalatest for testing our library
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.scalatest:scalatest_2.13:3.2.10")
    testImplementation("org.scalatestplus:junit-4-13_2.13:3.2.2.0")


    // Need scala-xml at test runtime
    testRuntimeOnly("org.scala-lang.modules:scala-xml_2.13:1.2.0")

    // IngSis
    implementation("org.austral.ingsis.printscript:printscript-parser-common:0.1.0")

}
