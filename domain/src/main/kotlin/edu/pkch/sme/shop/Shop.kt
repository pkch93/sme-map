package edu.pkch.sme.shop

import edu.pkch.sme.Address

class Shop(
    val id: Long,
    val name: String,
    val branch: String,
    val category: String,
    val subCategory: String,
    val industry: String,
    val address: Address
)