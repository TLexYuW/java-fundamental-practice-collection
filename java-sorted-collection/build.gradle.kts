plugins {
    id("groovy")
    id("java")
}

group = "com.lex.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//val itextVersion = "8.0.2"

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

    // https://mvnrepository.com/artifact/com.itextpdf/itextpdf
    implementation("com.itextpdf:itextpdf:5.5.13.4")


    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
//    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
//    implementation("org.apache.logging.log4j:log4j-api:2.23.1")

    implementation("net.datafaker:datafaker:2.1.0")

//    implementation("com.itextpdf:kernel:$itextVersion")
//    implementation("com.itextpdf:layout:$itextVersion")
//    implementation("com.itextpdf:font-asian:$itextVersion")
//    implementation("com.itextpdf:forms:$itextVersion")
//    implementation("com.itextpdf:io:$itextVersion")
//    implementation("com.itextpdf:pdfa:$itextVersion")
//    implementation("com.itextpdf:barcodes:$itextVersion")
//    implementation("com.itextpdf:sign:$itextVersion")
//    implementation("com.itextpdf:svg:$itextVersion")
//    implementation("com.itextpdf:hyph:$itextVersion")
//    implementation("com.itextpdf:itextpdf:5.5.13.4")
//    implementation("com.itextpdf:html2pdf:5.0.5")

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