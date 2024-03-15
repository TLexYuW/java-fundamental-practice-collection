import org.gradle.kotlin.dsl.accessors.runtime.externalModuleDependencyFor

plugins {
    id("java")
}

group = "com.lex.practice.spi"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/service-provider-interface-lex.jar"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveFileName.set("service-provider-lex.jar")
}