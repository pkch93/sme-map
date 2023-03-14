package edu.pkch.sme.opensearch

import edu.pkch.support.OpenSearchConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(OpenSearchConfiguration::class)
abstract class OpenSearchIntegrationTest