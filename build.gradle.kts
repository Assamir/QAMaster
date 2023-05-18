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
    testImplementation("org.seleniumhq.selenium", "selenium-java", "4.9.1")
    testImplementation("io.rest-assured", "rest-assured", "5.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))

}

tasks.test {
    useJUnitPlatform()
}