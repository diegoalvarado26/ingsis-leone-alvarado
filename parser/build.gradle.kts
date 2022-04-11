    plugins{
// Apply the java-library plugin for API and implementation separation.
    `java-library`

    // Maneja el tema de getters y setters y builders, una maravilla
    id("io.freefair.lombok") version "6.4.1"
}


repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/austral-ingsis/printscript-parser-common")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                // username = "diego"
                password = project.findProperty("gpr.key")as String? ?: System.getenv("TOKEN")
            }
        }
    }

}

dependencies {
    // Agregamos ellexer como dependencia
    implementation(project(":lexer"))
    implementation("org.projectlombok:lombok:1.18.20")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // IngSis
    implementation("org.austral.ingsis.printscript:printscript-parser-common:0.1.0")


    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("junit:junit:4.13.1")

}
tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
