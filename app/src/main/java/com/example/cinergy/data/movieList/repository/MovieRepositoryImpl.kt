package com.example.cinergy.data.movieList.repository

import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.data.common.util.MockDataUtil
import com.example.cinergy.data.movieList.api.MovieListApi
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.movieList.model.AvailableDate
import com.example.cinergy.domain.movieList.model.MovieListRequest
import com.example.cinergy.domain.movieList.model.MovieListResponse
import com.example.cinergy.domain.movieList.repository.MovieListRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl @Inject constructor(
    private val escapeMovieListApi: MovieListApi,
    private val moshi: Moshi
) : MovieListRepository {

    override suspend fun getMovieList(escapeRoomMovieListRequest: MovieListRequest): Flow<BaseResult<List<MovieListResponse>, LoginGenericResponse>> {
        return flow {
//            val headers= HashMap<String, String>()
//            headers[AUTHORIZATION_HEADER_TAG] = BEARER + AppConstant.token
//            val escapeRoomMovieResponse = escapeMovieListApi.getEscapeRoomMovieList(headers, escapeRoomMovieListRequest.toEscapeRoomMovieListRequest())

            val movieResponse = MockDataUtil.getEscapeMovieList()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.let { movieList ->
                    val movieListResponse = ArrayList<MovieListResponse>()
                    var availableDateList: ArrayList<AvailableDate>
                    movieList.forEach { movie ->
                        availableDateList = ArrayList<AvailableDate>()
                        movie.availableDate.forEach { availableDateDto ->
                            availableDateList.add(
                                AvailableDate(
                                    day = availableDateDto.day,
                                    date = availableDateDto.date,
                                    availableTimeList = availableDateDto.availableTimeList
                                )
                            )
                        }
                        movieListResponse.add(
                            MovieListResponse(
                                movieId = movie.movieId,
                                movieTitle = movie.movieTitle,
                                movieDuration = movie.movieDuration,
                                members = movie.members,
                                movieSubTitle = movie.movieSubTitle,
                                movieDescription = movie.movieDescription,
                                movieImageUrl = movie.movieImageUrl,
                                availableDate = availableDateList
                            )
                        )
                    }
                    emit(BaseResult.Success(movieListResponse))
                }
            } else {
                val jsonAdapter: JsonAdapter<LoginGenericResponse> =
                    moshi.adapter(LoginGenericResponse::class.java)

                movieResponse.errorBody()?.let { responseBody ->
                    jsonAdapter.fromJson(responseBody.string())?.let { error ->
                        emit(BaseResult.Error(error))
                    } ?: run {
                        emit(
                            BaseResult.Error(
                                LoginGenericResponse().apply {
                                    message = movieResponse.raw().toString()
                                }
                            )
                        )
                    }
                }
            }
        }.catch {
            emit(
                BaseResult.Error(
                    LoginGenericResponse().apply {
                        message = "Get movie api is failed"
                    }
                )
            )
        }
    }
}
