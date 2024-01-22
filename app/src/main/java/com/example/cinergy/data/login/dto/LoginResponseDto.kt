package com.example.cinergy.data.login.dto

import com.squareup.moshi.Json

data class LoginResponseDto(
    @Json(name = "response")
    val response: String,
    @Json(name = "user")
    val user: UserDto,
    @Json(name = "food_menu")
    val foodMenu: Long,
    @Json(name = "attractions_menu")
    val attractionsMenu: Long,
    @Json(name = "splash_images")
    val splashImages: SplashImageDto
)