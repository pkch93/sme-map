dependencies {
    implementation(project(":domain"))

    val openSearchClientVersion: String by project
    val openSearchJavaVersion: String by project
    implementation("org.opensearch.client:opensearch-rest-client:${openSearchClientVersion}")
    implementation("org.opensearch.client:opensearch-java:${openSearchJavaVersion}")
}
