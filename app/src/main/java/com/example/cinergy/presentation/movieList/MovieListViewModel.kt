package com.example.cinergy.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinergy.data.common.util.AppConstant
import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.data.common.util.UUIDType5
import com.example.cinergy.domain.movieList.model.MovieListRequest
import com.example.cinergy.domain.movieList.useCase.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val escapeMovieListUseCase: MovieListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MovieListState>(MovieListState.Init)
    val state: StateFlow<MovieListState> get() = _state

    fun onStateChangeHandled() {
        _state.value = MovieListState.Init
    }

    fun onBackClicked() {
        _state.value = MovieListState.BackClicked
    }

    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            escapeMovieListUseCase.getMovieList(
                MovieListRequest(
                    deviceId = AppConstant.DEVICE_ID_PREFIX + UUIDType5.nameUUIDFromNamespaceAndBytes(
                        UUID.randomUUID(), AppConstant.UUID_TYPE5_KEY.toByteArray()
                    ).toString(),
                    memberId = AppConstant.getMemberId(),
                    locationId = AppConstant.getLocationId(),
                    deviceType = "2",
                )
            )
                .onStart {
                }.catch {
                    _state.value = MovieListState.UnknownError
                }.collect { baseResult ->
                    when (baseResult) {
                        is BaseResult.Error -> {
                            _state.value = MovieListState.UnknownError
                        }

                        is BaseResult.Success -> {
                            _state.value =
                                MovieListState.UpdateMovieListRecyclerView(baseResult.data)
                        }
                    }
                }
        }
    }
}
