package com.example.cinergy.data.login.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequestDto(
    @Json(name = "device_id")
    val deviceId: String,
    @Json(name = "device_type")
    val deviceType: String,
    @Json(name = "login_type")
    val loginType: String
)