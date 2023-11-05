plugins {
    java
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("io.github.bonigarcia:webdrivermanager:5.3.2")
    implementation("org.seleniumhq.selenium:selenium-remote-driver:4.14.1")
//    implementation("org.seleniumhq.selenium:selenium-remote-driver:4.15.0")
//    implementation("org.seleniumhq.selenium:selenium-remote-driver:3.141.59")
    implementation("org.apache.commons:commons-lang3:3.13.0")


//    implementation("org.openqa.selenium.webdriver:webdriver-common:0.6.1039")
//    implementation("io.github.bonigarcia:webdrivermanager:5.6.0")

    implementation("io.appium:java-client:9.0.0")


    implementation("com.microsoft.playwright:playwright:1.34.0")
    implementation("com.typesafe:config:1.4.2")
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("io.qameta.allure:allure-java-commons:2.23.0")
    testImplementation("io.qameta.allure:allure-junit5:2.23.0")
    testImplementation("io.qameta.allure:allure-commandline:2.13.9")
//    testImplementation("junit:junit:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}

// Allure configuration
tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<Exec>("allureReport") {
    dependsOn("test")
    commandLine = listOf("allure", "generate", "build/allure-results", "--clean", "-o", "build/allure-report")
}
