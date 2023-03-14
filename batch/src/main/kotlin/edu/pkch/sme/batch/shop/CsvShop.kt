package edu.pkch.sme.batch.shop

import edu.pkch.sme.Address
import edu.pkch.sme.Coordinate
import edu.pkch.sme.shop.Shop

data class CsvShop(
    val name: String,
    val branch: String,
    val category: String,
    val subCategory: String,
    val industry: String,
    val sido: String,
    val gugun: String,
    val administrativeDong: String,
    val legalDong: String,
    val dongPrimaryNo: String,
    val dongSecondaryNo: String,
    val road: String,
    val roadPrimaryNo: String,
    val roadSecondaryNo: String,
    val buildingName: String,
    val longitude: Double,
    val latitude: Double
) {
    fun toShop(): Shop {
        return Shop(
            name,
            branch,
            category,
            subCategory,
            industry,
            Address(
                sido,
                gugun,
                administrativeDong,
                legalDong,
                dongPrimaryNo,
                dongSecondaryNo,
                road,
                roadPrimaryNo,
                roadSecondaryNo,
                buildingName,
                Coordinate(
                    latitude,
                    longitude
                )
            )
        )
    }
}