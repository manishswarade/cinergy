package com.example.cinergy.presentation.movieSchedule

sealed class MovieScheduleState {
    object Init : MovieScheduleState()
    object BackClicked : MovieScheduleState()
}
