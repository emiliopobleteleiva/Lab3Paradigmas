plugins {
    id("java")
    application
}

group = "org.con4"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.con4.Main") // Clase principal con paquete completo
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}