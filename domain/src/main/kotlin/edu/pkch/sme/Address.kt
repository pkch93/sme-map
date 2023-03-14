package edu.pkch.sme

class Address(
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
    val coordinate: Coordinate
) {
    val jibunFullAddress: String
        get() = "$sido $gugun $legalDong ${addressNo(dongPrimaryNo, dongSecondaryNo)} $buildingName"
    val roadFullAddress: String
        get() = "$sido $gugun $road ${addressNo(roadPrimaryNo, roadSecondaryNo)} $buildingName"

    private fun addressNo(primaryNo: String, secondaryNo: String): String {
        if (secondaryNo == "") {
            return primaryNo
        }

        return "${primaryNo}-${secondaryNo}"
    }
}