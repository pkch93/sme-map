import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
val jar: Jar by tasks
bootJar.enabled = false
jar.enabled = true

dependencies {
    val testContainerVersion: String by project
    val openSearchClientVersion: String by project
    val openSearchJavaVersion: String by project
    implementation("org.testcontainers:testcontainers:${testContainerVersion}")
    implementation("org.testcontainers:junit-jupiter:${testContainerVersion}")
    implementation("org.opensearch.client:opensearch-rest-client:${openSearchClientVersion}")
    implementation("org.opensearch.client:opensearch-java:${openSearchJavaVersion}")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter-test")
}
