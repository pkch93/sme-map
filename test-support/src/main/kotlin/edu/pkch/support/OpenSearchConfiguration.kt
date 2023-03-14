package edu.pkch.support

import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.apache.http.HttpHost
import org.apache.http.client.HttpClient
import org.opensearch.client.Request
import org.opensearch.client.RestClient
import org.opensearch.client.json.jackson.JacksonJsonpMapper
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.transport.rest_client.RestClientTransport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.ClassPathResource
import org.testcontainers.containers.DockerComposeContainer
import java.io.File
import java.io.FileOutputStream
import java.net.Socket
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

private const val RETRY_LIMIT = 20
private val log = KotlinLogging.logger(OpenSearchConfiguration::class.java.name)

@Configuration
class OpenSearchConfiguration(
    private val objectMapper: ObjectMapper
) {
    private lateinit var container: DockerComposeContainer<*>
    private lateinit var dockerComposeFile: File
    private var retry: Int = 0

    @PostConstruct
    fun start() {
        if (isOpenSearchDockerContainerHealthy()) {
            log.info { "opensearch docker container is already running..." }
            return
        }

        log.info { "opensearch docker container start" }
        dockerComposeFile = extractDockerComposeFile("docker-compose.yml")
        container = DockerComposeContainer(dockerComposeFile).withServices("opensearch")
        container.start()
        waitHealthy()
    }

    /**
     * docker-compose로 띄우는 컨테이너들의 포트를 확인해서 체크
     */
    private fun isOpenSearchDockerContainerHealthy(): Boolean {
        return try {
            Socket("127.0.0.1", 9201).close()
            true
        } catch (exception: Exception) {
            false
        }
    }

    private fun extractDockerComposeFile(path: String): File {
        val dockerComposeInputStream = ClassPathResource(path).inputStream
        val dockerComposeFile = File.createTempFile("docker-compose", ".yml")

        FileOutputStream(dockerComposeFile).use { fos ->
            var read: Int
            val bytes = ByteArray(1024)
            while (dockerComposeInputStream.read(bytes).also { read = it } != -1) {
                fos.write(bytes, 0, read)
            }
        }

        return dockerComposeFile
    }

    private fun waitHealthy() {
        while (retry < RETRY_LIMIT) {
            try {
                val healthCheckClient = RestClient.builder(HttpHost("127.0.0.1", 9201, "http")).build()
                val response = healthCheckClient.performRequest(Request("GET", "/"))
                if (response.statusLine.statusCode == 200) {
                    break
                }
            } catch (e: Exception) {
                log.error { "opensearch container is not healthy. retry ${retry}" }
            } finally {
                retry += 1
                Thread.sleep(1000)
            }

        }

        if (retry == RETRY_LIMIT) {
            throw IllegalStateException("opensearch container is not healthy")
        }
        log.info { "opensearch docker container start completed" }
    }

    @PreDestroy
    fun stop() {
        container.stop()
        dockerComposeFile.delete()
    }

    @Bean
    @Primary
    fun testOpenSearchClient(): OpenSearchClient {
        val restClient = RestClient.builder(HttpHost("127.0.0.1", 9201, "http")).build()
        val transport = RestClientTransport(restClient, JacksonJsonpMapper(objectMapper))
        return OpenSearchClient(transport)
    }
}