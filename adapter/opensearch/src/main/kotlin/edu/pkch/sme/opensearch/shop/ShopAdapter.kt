package edu.pkch.sme.opensearch.shop

import edu.pkch.sme.shop.SaveAllShopPort
import edu.pkch.sme.shop.SaveShopPort
import edu.pkch.sme.shop.Shop
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ShopAdapter(
    private val saveShopMutation: SaveShopMutation
): SaveShopPort, SaveAllShopPort
{
    override fun save(shop: Shop) = Unit

    override fun saveAll(shops: List<Shop>) {
        val now = LocalDate.now()
        val shopDocuments = ShopDocument.createDocuments(shops)
        saveShopMutation.saveAll(shopDocuments, now)
    }
}