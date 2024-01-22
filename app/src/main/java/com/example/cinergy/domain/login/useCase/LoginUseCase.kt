package com.example.cinergy.domain.login.useCase

import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.domain.login.model.AuthTokenRequest
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.login.model.LoginResponse
import com.example.cinergy.domain.login.repository.LoginRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend fun getGuestToken(authTokenRequest: AuthTokenRequest): Flow<BaseResult<LoginResponse, LoginGenericResponse>> {
        return repository.getGuestToken(authTokenRequest)
    }
}
