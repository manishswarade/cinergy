package com.example.cinergy.data.movieList.api

import com.example.cinergy.data.movieList.dto.MovieListRequestDto
import com.example.cinergy.data.movieList.dto.MovieListResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface MovieListApi {
    @POST("https://cinergyapp.thetunagroup.com/api/getMovieInfo")
    suspend fun getMovieList(
        @HeaderMap headers: Map<String, String>,
        @Body escapeMovieListRequestDto: MovieListRequestDto
    ): Response<MovieListResponseDto>
}