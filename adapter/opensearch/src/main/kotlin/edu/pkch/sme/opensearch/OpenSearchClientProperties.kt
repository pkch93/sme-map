package edu.pkch.sme.opensearch

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("opensearch.client")
class OpenSearchClientProperties(
    val hostname: String,
    val port: Int
)