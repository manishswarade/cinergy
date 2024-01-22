package com.example.cinergy.data.movieList.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListResponseDto(
    @Json(name = "movie_id")
    val movieId: String,
    @Json(name = "movie_title")
    val movieTitle: String,
    @Json(name = "movie_duration")
    val movieDuration: String,
    @Json(name = "members")
    val members: String,
    @Json(name = "movie_sub_title")
    val movieSubTitle: String,
    @Json(name = "movie_description")
    val movieDescription: String,
    @Json(name = "movie_image")
    val movieImageUrl: String,
    @Json(name = "available_date")
    val availableDate: List<AvailableDateDto>
)