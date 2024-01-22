package com.example.cinergy.domain.movieList.model

import com.example.cinergy.data.movieList.dto.MovieListRequestDto

data class MovieListRequest(
    val deviceId: String,
    val memberId: String,
    val deviceType: String,
    val locationId: String,
)


fun MovieListRequest.toMovieListRequest(): MovieListRequestDto {
    return MovieListRequestDto(
        deviceId = this.deviceId,
        memberId = this.memberId,
        deviceType = this.deviceType,
        locationId = this.locationId
    )
}