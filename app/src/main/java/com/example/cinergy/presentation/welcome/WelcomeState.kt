package com.example.cinergy.presentation.welcome

sealed class WelcomeState {
    object Init : WelcomeState()
    object LoginSuccess : WelcomeState()
    object UnknownError : WelcomeState()
    object ShowProgressBar : WelcomeState()
    object HideProgressBar : WelcomeState()
}
