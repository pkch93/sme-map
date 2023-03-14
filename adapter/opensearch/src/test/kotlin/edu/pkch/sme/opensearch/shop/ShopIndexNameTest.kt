package edu.pkch.sme.opensearch.shop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class ShopIndexNameTest {
    @Test
    fun create() {
        val date = LocalDate.of(2023, 2, 18)

        val sut = ShopIndexName(date)

        assertThat(sut.value).isEqualTo("shop-2023-02-18")
    }
}