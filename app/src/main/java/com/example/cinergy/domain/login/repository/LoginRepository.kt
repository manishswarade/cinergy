package com.example.cinergy.domain.login.repository

import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.domain.login.model.AuthTokenRequest
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.login.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun getGuestToken(authTokenRequest: AuthTokenRequest): Flow<BaseResult<LoginResponse, LoginGenericResponse>>
}
