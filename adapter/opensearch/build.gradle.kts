tasks {
    bootJar { enabled = false }
    jar { enabled = true }
}

dependencies {
    implementation(project(":domain"))

    val openSearchClientVersion: String by project
    val openSearchJavaVersion: String by project
    implementation("org.opensearch.client:opensearch-rest-client:${openSearchClientVersion}")
    implementation("org.opensearch.client:opensearch-java:${openSearchJavaVersion}")

    val jakartaJsonApiVersion: String by project
    implementation("jakarta.json:jakarta.json-api:${jakartaJsonApiVersion}")
    implementation("org.springframework.boot:spring-boot-starter-json")

    testImplementation(project(":test-support"))
}
