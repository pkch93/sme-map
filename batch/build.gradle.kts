dependencies {
    implementation(project(":domain"))
    implementation(project(":adapter:opensearch"))

    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    val jakartaJsonApiVersion: String by project
    implementation("jakarta.json:jakarta.json-api:${jakartaJsonApiVersion}")
    testImplementation("org.springframework.batch:spring-batch-test")
}
