plugins {
    id("java")
}

group = "com.lex"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.projectreactor:reactor-core:3.5.11")
    testImplementation("io.projectreactor:reactor-test:3.5.11")

//    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
//    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex:rxjava:1.3.8")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    testCompileOnly ("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.30")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}