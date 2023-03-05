package edu.pkch.sme.opensearch

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.json.jackson.JacksonJsonpMapper
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.transport.rest_client.RestClientTransport
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(OpenSearchClientProperties::class)
class OpenSearchClientConfiguration {

    @Bean
    fun openSearchClient(properties: OpenSearchClientProperties,
                         objectMapper: ObjectMapper): OpenSearchClient {
        val restClient = RestClient.builder(HttpHost(properties.hostname, properties.port)).build()
        val transport = RestClientTransport(restClient, JacksonJsonpMapper())
        return OpenSearchClient(transport)
    }
}