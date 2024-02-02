plugins {
    id("java")
}

group = "com.lex.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.apache.httpcomponents:httpclient:4.5.14")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.16.1")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.16.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.1")


    // https://mvnrepository.com/artifact/net.sf.py4j/py4j
    implementation("net.sf.py4j:py4j:0.10.9.7")

    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.assertj:assertj-core:3.25.2")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")

}

tasks.test {
    useJUnitPlatform()
}