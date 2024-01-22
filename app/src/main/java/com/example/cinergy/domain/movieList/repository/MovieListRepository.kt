package com.example.cinergy.domain.movieList.repository

import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.movieList.model.MovieListRequest
import com.example.cinergy.domain.movieList.model.MovieListResponse
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(escapeRoomMovieListRequest: MovieListRequest): Flow<BaseResult<List<MovieListResponse>, LoginGenericResponse>>
}
