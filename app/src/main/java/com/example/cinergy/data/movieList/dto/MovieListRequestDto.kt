package com.example.cinergy.data.movieList.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListRequestDto(
    @Json(name = "device_id")
    val deviceId: String,
    @Json(name = "member_id")
    val memberId: String,
    @Json(name = "device_type")
    val deviceType: String,
    @Json(name = "location_id")
    val locationId: String
)