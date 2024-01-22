package com.example.cinergy.data.movieList.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AvailableDateDto(
    @Json(name = "day")
    val day: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "availableTimeList")
    val availableTimeList: List<String>
)