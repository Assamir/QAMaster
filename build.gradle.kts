plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.bonigarcia", "webdrivermanager", "5.3.2")
    implementation("com.microsoft.playwright", "playwright","1.34.0")
    implementation("com.typesafe","config", "1.4.2")
    implementation("org.junit.jupiter:junit-jupiter")
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.slf4j:slf4j-api:2.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))

}

tasks.test {
    useJUnitPlatform()
}