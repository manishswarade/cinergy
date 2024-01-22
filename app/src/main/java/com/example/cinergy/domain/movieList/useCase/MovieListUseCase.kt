package com.example.cinergy.domain.movieList.useCase

import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.movieList.model.MovieListRequest
import com.example.cinergy.domain.movieList.model.MovieListResponse
import com.example.cinergy.domain.movieList.repository.MovieListRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MovieListUseCase @Inject constructor(
    private val repository: MovieListRepository
) {
    suspend fun getMovieList(escapeRoomMovieListRequest: MovieListRequest): Flow<BaseResult<List<MovieListResponse>, LoginGenericResponse>> {
        return repository.getMovieList(escapeRoomMovieListRequest)
    }
}
