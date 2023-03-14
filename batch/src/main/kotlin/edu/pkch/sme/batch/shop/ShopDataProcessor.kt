package edu.pkch.sme.batch.shop

import edu.pkch.sme.shop.Shop
import org.springframework.batch.item.ItemProcessor

class ShopDataProcessor: ItemProcessor<CsvShop, Shop> {

    override fun process(csvShop: CsvShop): Shop {
        return csvShop.toShop()
    }
}