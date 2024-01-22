package com.example.cinergy.data.login.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthTokenRequestDto(
    @Json(name = "secret_key")
    val secretKey: String,
    @Json(name = "device_type")
    val deviceType: String,
    @Json(name = "device_id")
    val deviceId: String,
    @Json(name = "push_token")
    val pushToken: String
)