plugins {
    java
    id("io.qameta.allure") version "2.11.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "qamaster"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.bonigarcia:webdrivermanager:5.3.2")
    implementation("com.microsoft.playwright:playwright:1.34.0")
    implementation("com.typesafe:config:1.4.2")
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("io.qameta.allure:allure-java-commons:2.23.0")
    implementation("org.eclipse.persistence:javax.persistence:2.2.1")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")


    implementation("org.springframework:spring-context:6.0.11")
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.2")
    implementation("org.springframework.boot:spring-boot-autoconfigure-processor:3.1.2")




    testImplementation("org.hsqldb:hsqldb:2.7.2")
    testImplementation("io.qameta.allure:allure-junit5:2.23.0")
    testImplementation("io.qameta.allure:allure-commandline:2.13.9")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.2")


//    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")


}

tasks.test {
    useJUnitPlatform()
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
    jvmArgs("--add-opens", "java.base/java.util=ALL-UNNAMED")
}

// Allure configuration
tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<Exec>("allureReport") {
    dependsOn("test")
    commandLine = listOf("allure", "generate", "build/allure-results", "--clean", "-o", "build/allure-report")
}
