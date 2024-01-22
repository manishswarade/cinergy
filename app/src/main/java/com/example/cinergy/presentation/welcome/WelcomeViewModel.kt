package com.example.cinergy.presentation.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinergy.data.common.util.AppConstant
import com.example.cinergy.data.common.util.AppConstant.DEVICE_ID_PREFIX
import com.example.cinergy.data.common.util.AppConstant.UUID_TYPE5_KEY
import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.data.common.util.UUIDType5.nameUUIDFromNamespaceAndBytes
import com.example.cinergy.domain.login.model.AuthTokenRequest
import com.example.cinergy.domain.login.useCase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<WelcomeState>(WelcomeState.Init)
    val state: StateFlow<WelcomeState> get() = _state

    fun onStateChangeHandled() {
        _state.value = WelcomeState.Init
    }

    fun onContinueAsGuestClick() {
        getGuestToken()
    }

    private fun getGuestToken() {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.getGuestToken(
                AuthTokenRequest(
                    secretKey = AppConstant.getSecretKey(),
                    deviceType = "2",
                    deviceId = DEVICE_ID_PREFIX + nameUUIDFromNamespaceAndBytes(
                        UUID.randomUUID(),
                        UUID_TYPE5_KEY.toByteArray()
                    ).toString(),
                    pushToken = "",
                    loginType = "2"
                )
            )
                .onStart {
                    withContext(Main) {
                        _state.value = WelcomeState.ShowProgressBar
                    }
                }.catch {
                    withContext(Main) {
                        _state.value = WelcomeState.HideProgressBar
                        _state.value = WelcomeState.UnknownError
                    }
                }.collect { baseResult ->
                    withContext(Main) {
                        _state.value = WelcomeState.HideProgressBar
                    }
                    when (baseResult) {
                        is BaseResult.Error -> {
                            _state.value = WelcomeState.UnknownError
                        }

                        is BaseResult.Success -> {
                            _state.value = WelcomeState.LoginSuccess
                        }
                    }
                }
        }
    }
}
