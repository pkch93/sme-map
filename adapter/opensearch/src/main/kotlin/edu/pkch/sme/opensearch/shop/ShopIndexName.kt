package edu.pkch.sme.opensearch.shop

import edu.pkch.sme.opensearch.common.IndexName
import java.time.LocalDate

private const val SHOP_INDEX_PREFIX = "shop"

class ShopIndexName
    private constructor(private val indexName: IndexName)
{
    val value: String
        get() = indexName.name

    constructor(date: LocalDate): this(IndexName(SHOP_INDEX_PREFIX, date))
}