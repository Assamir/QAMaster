plugins {
    java
    id("io.qameta.allure") version "2.11.2"
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenium WebDriver dependencies
    implementation("org.seleniumhq.selenium:selenium-remote-driver:4.14.1")

    // Apache Commons Lang, which provides extra functionality for classes in java.lang
    implementation("org.apache.commons:commons-lang3:3.13.0")

    // Appium Java client for mobile application testing
    implementation("io.appium:java-client:9.0.0")

    // TestFX for JavaFX UI testing
    implementation("org.testfx:testfx-core:4.0.17")
    implementation("org.testfx:testfx-junit:4.0.17")
    implementation("org.testfx:testfx-junit5:4.0.17")
    implementation("org.openjfx:javafx-fxml:22-ea+16")
    implementation("org.openjfx:javafx-controls:22-ea+16")

    implementation("org.springframework.boot:spring-boot-starter:3.1.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")



    // Playwright for browser automation
    implementation("com.microsoft.playwright:playwright:1.34.0")

    // TypeSafe Config for handling configuration files
    implementation("com.typesafe:config:1.4.2")

    // JUnit Jupiter API and Engine for testing
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")

    // AssertJ for fluent assertions in tests
    implementation("org.assertj:assertj-core:3.24.2")
    implementation("org.hamcrest:hamcrest:2.2")


    // TestFX integration with JUnit 5
    implementation("org.testfx:testfx-junit5:4.0.17")

    // SLF4J for logging
    implementation("org.slf4j:slf4j-api:2.0.0")

    // Allure dependencies for reporting
    implementation("io.qameta.allure:allure-java-commons:2.23.0")
    testImplementation("io.qameta.allure:allure-junit5:2.23.0")
    testImplementation("io.qameta.allure:allure-commandline:2.13.9")

    testImplementation(files("D:/_src/QAMaster/src/main/resources/pairwise.jar"))
}

javafx {
    version = "17" // Replace with the desired JavaFX version
    modules("javafx.controls", "javafx.fxml") // Include the necessary JavaFX modules
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
