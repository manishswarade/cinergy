package com.example.cinergy.presentation.movieDetailBottomSheet

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow<MovieDetailState>(MovieDetailState.Init)
    val state: StateFlow<MovieDetailState> get() = _state

    fun onStateChangeHandled() {
        _state.value = MovieDetailState.Init
    }

    fun onCloseClick() {
        _state.value = MovieDetailState.Close
    }

    fun onInfoClick() {
        _state.value = MovieDetailState.Close
    }

    fun onBookNowClicked() {
        _state.value = MovieDetailState.BookNowClicked
    }
}
