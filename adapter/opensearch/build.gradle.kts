dependencies {
    implementation(project(":domain"))

    val openSearchClientVersion: String by project
    val openSearchJavaVersion: String by project
    implementation("org.opensearch.client:opensearch-rest-client:${openSearchClientVersion}")
    implementation("org.opensearch.client:opensearch-java:${openSearchJavaVersion}")
    implementation("jakarta.json:jakarta.json-api:2.0.1")
    implementation("org.springframework.boot:spring-boot-starter-json")
}
