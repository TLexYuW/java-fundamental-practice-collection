plugins {
    id("groovy")
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

    // https://mvnrepository.com/artifact/com.alibaba/easyexcel
    implementation("com.alibaba:easyexcel:4.0.1")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor ("org.projectlombok:lombok:1.18.34")
    testCompileOnly ("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.34")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
//    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
//    implementation("org.apache.logging.log4j:log4j-api:2.23.1")

    implementation("net.datafaker:datafaker:2.1.0")

    // https://mvnrepository.com/artifact/net.sf.py4j/py4j
    implementation("net.sf.py4j:py4j:0.10.9.7")

    implementation(gradleApi())

    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.assertj:assertj-core:3.25.2")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")

}

tasks.test {
    useJUnitPlatform()
}