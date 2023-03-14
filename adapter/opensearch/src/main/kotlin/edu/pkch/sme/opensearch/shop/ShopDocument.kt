package edu.pkch.sme.opensearch.shop

import edu.pkch.sme.shop.Shop

data class ShopDocument(
    val id: Long,
    val name: String,
    val branch: String,
    val category: String,
    val location: String,
) {
    companion object Factory {
        fun createDocuments(shops: List<Shop>): List<ShopDocument> {
            return shops.map { ShopDocument(it) }
        }
    }

    constructor(shop: Shop): this(
        1,
        shop.name,
        shop.branch,
        shop.category,
        "${shop.address.coordinate.latitude}, ${shop.address.coordinate.longitude}"
    )
}