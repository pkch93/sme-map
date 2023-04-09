package edu.pkch.sme.opensearch.shop

import edu.pkch.sme.Address
import edu.pkch.sme.Coordinate
import edu.pkch.sme.opensearch.OpenSearchIntegrationTest
import edu.pkch.sme.shop.Shop
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

internal class SaveShopMutationTest
    @Autowired constructor(val sut: SaveShopMutation): OpenSearchIntegrationTest() {

    @Test
    fun saveAll() {
        val now = LocalDate.of(2023, 2, 18)
        val shop = Shop(
            1L,
            "가게1",
            "",
            "한식",
            "한식/백반/한정식",
            "한식 음식점업",
            Address(
                "서울특별시",
                "송파구",
                "방이2동",
                "방이동",
                "112",
                "5",
                "백제고분로48길",
                "12",
                "22",
                "",
                Coordinate(37.51457363, 127.10592756)
            )
        )
        val shopDocuments = listOf(ShopDocument(shop))

        sut.saveAll(shopDocuments, now)
    }
}