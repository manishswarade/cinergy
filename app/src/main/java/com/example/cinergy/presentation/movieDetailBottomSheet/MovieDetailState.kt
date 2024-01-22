package com.example.cinergy.presentation.movieDetailBottomSheet

sealed class MovieDetailState {
    object Init : MovieDetailState()
    object Close : MovieDetailState()
    object BookNowClicked : MovieDetailState()
}
