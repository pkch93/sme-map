package edu.pkch.sme

private const val KOREA_SOUTH_LATITUDE: Double = 33.0
private const val KOREA_NORTH_LATITUDE: Double = 43.0
private const val KOREA_WEST_LONGITUDE: Double = 124.0
private const val KOREA_EAST_LONGITUDE: Double = 132.0

class Coordinate(
    val latitude: Double,
    val longitude: Double
) {

    init {
        if (!isValidCoordinate(latitude, longitude)) {
            throw IllegalArgumentException("유효하지 않는 위경도입니다.")
        }
    }

    private fun isValidCoordinate(latitude: Double, longitude: Double): Boolean {
        return ((KOREA_SOUTH_LATITUDE < latitude) and (latitude < KOREA_NORTH_LATITUDE)) and
                ((KOREA_WEST_LONGITUDE < longitude) and (longitude < KOREA_EAST_LONGITUDE))
    }
}