dependencies {
    implementation(project(":domain"))

    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    testImplementation("org.springframework.batch:spring-batch-test")
}
