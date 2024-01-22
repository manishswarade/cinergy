package com.example.cinergy.domain.movieList.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieListResponse(
    val movieId: String,
    val movieTitle: String,
    val movieDuration: String,
    val members: String,
    val movieSubTitle: String,
    val movieDescription: String,
    val movieImageUrl: String,
    val availableDate: List<AvailableDate>
) : Parcelable
