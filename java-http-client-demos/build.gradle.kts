plugins {
    id("java")
}

group = "com.lex"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.3-alpha1")
    implementation("org.asynchttpclient:async-http-client:2.12.3")
    implementation("org.eclipse.jetty:jetty-client:12.0.2")
    implementation("org.eclipse.jetty:jetty-client:12.0.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}