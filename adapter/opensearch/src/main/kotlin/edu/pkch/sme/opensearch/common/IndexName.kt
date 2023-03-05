package edu.pkch.sme.opensearch.common

import java.time.LocalDate

data class IndexName(
    val name: String
) {
    constructor(prefix: String, date: LocalDate): this("${prefix}-${date}")
}