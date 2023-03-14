package edu.pkch.sme.shop

import edu.pkch.sme.Coordinate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class CoordinateTest {

    @Test
    fun create() {
        assertDoesNotThrow { Coordinate(37.5144533, 127.1059047) }
    }

    @Test
    fun invalid() {
        assertThatThrownBy { Coordinate(34.6698654, 135.504237) }
    }
}