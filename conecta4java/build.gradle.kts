plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.example.Main_204446830_PobleteLeiva")
}

tasks.test {
    useJUnitPlatform()
}

// Configuración del estándar de entrada para la tarea run
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
