package com.example.cinergy.data.login.dto

import com.squareup.moshi.Json

data class SplashImageDto(
    @Json(name = "splash_image_top")
    val splashImageTop: String,
    @Json(name = "splash_image_bottom")
    val splashImageBottom: String
)