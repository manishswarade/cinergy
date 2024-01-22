package com.example.cinergy.presentation.movieList

import com.example.cinergy.domain.movieList.model.MovieListResponse

sealed class MovieListState {
    object Init : MovieListState()
    object BackClicked : MovieListState()
    data class UpdateMovieListRecyclerView(val data: List<MovieListResponse>) : MovieListState()
    object UnknownError : MovieListState()
}
