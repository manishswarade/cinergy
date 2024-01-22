package com.example.cinergy.data.login.dto

import com.squareup.moshi.Json

data class AuthTokenResponseDto(
    @Json(name = "response")
    var response: String? = null,
    @Json(name = "token")
    var token: String? = null,
    @Json(name = "printer_name")
    var printerName: String? = null,
    @Json(name = "food_menu")
    var foodMenu: Int? = null,
    @Json(name = "attractions_menu")
    var attractionsMenu: Int? = null,
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "location")
    var location: String? = null
)