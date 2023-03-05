package edu.pkch.sme.opensearch.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class IndexNameTest {
    @Test
    fun create() {
        val sut = IndexName("shop", LocalDate.of(2023, 2, 18))

        assertThat(sut).isEqualTo(IndexName("shop-2023-02-18"))
    }
}