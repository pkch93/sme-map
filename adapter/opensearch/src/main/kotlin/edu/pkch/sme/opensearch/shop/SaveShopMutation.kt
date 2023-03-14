package edu.pkch.sme.opensearch.shop

import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.opensearch.core.BulkRequest
import org.opensearch.client.opensearch.core.bulk.BulkOperation
import org.opensearch.client.opensearch.core.bulk.CreateOperation
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class SaveShopMutation(
    private val openSearchClient: OpenSearchClient
) {
    fun saveAll(shopDocuments: List<ShopDocument>, date: LocalDate) {
        val shopIndexName = ShopIndexName(date)
        val bulkOperations = shopDocuments.map { shopDocument ->
            BulkOperation.of { builder ->
                builder.create(
                    CreateOperation.Builder<ShopDocument>()
                        .id(shopDocument.id.toString())
                        .document(shopDocument)
                        .build())
            }
        }

        val request = BulkRequest.Builder()
            .index(shopIndexName.value)
            .operations(bulkOperations)
            .build()

        openSearchClient.bulk(request)
    }
}