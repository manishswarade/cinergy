package com.example.cinergy.presentation.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow<MainActivityState>(MainActivityState.Init)
    val state: StateFlow<MainActivityState> get() = _state

    var progressVisibility = ObservableField(false)

    fun onStateChangeHandled() {
        _state.value = MainActivityState.Init
    }

    fun showProgressBar() {
        progressVisibility.set(true)
    }

    fun hideProgressBar() {
        progressVisibility.set(false)
    }
}
