package com.example.cinergy.presentation.movieSchedule

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MovieScheduleViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow<MovieScheduleState>(MovieScheduleState.Init)
    val state: StateFlow<MovieScheduleState> get() = _state

    fun onStateChangeHandled() {
        _state.value = MovieScheduleState.Init
    }

    fun onBackClicked() {
        _state.value = MovieScheduleState.BackClicked
    }
}
