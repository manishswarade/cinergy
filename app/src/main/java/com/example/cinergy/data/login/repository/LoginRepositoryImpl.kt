package com.example.cinergy.data.login.repository

import com.example.cinergy.data.common.util.AppConstant
import com.example.cinergy.data.common.util.AppConstant.AUTHORIZATION_HEADER_TAG
import com.example.cinergy.data.common.util.AppConstant.BEARER
import com.example.cinergy.data.common.util.BaseResult
import com.example.cinergy.data.login.api.LoginApi
import com.example.cinergy.domain.login.model.AuthTokenRequest
import com.example.cinergy.domain.login.model.LoginGenericResponse
import com.example.cinergy.domain.login.model.LoginResponse
import com.example.cinergy.domain.login.model.toAuthTokenRequestDto
import com.example.cinergy.domain.login.model.toLoginRequestDto
import com.example.cinergy.domain.login.repository.LoginRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val moshi: Moshi
) : LoginRepository {

    override suspend fun getGuestToken(authTokenRequest: AuthTokenRequest): Flow<BaseResult<LoginResponse, LoginGenericResponse>> {
        return flow {
            val authTokenResponse = loginApi.getGuestToken(authTokenRequest.toAuthTokenRequestDto())
            if (authTokenResponse.isSuccessful) {
                authTokenResponse.body()?.let { guestTokenApiResponse ->
                    val headers = HashMap<String, String>()
                    headers[AUTHORIZATION_HEADER_TAG] = BEARER + guestTokenApiResponse.token
                    val loginResponse =
                        loginApi.getLogin(headers, authTokenRequest.toLoginRequestDto())
                    if (loginResponse.isSuccessful) {
                        loginResponse.body()?.let { loginApiResponse ->
                            AppConstant.setLocationId(loginApiResponse.user.locationId ?: "")
                            AppConstant.setMemberId(loginApiResponse.user.memberId ?: "")
                            AppConstant.setToken(guestTokenApiResponse.token ?: "")
                            emit(
                                BaseResult.Success(
                                    LoginResponse(
                                        token = guestTokenApiResponse.token ?: "",
                                        memberId = loginApiResponse.user.memberId ?: ""
                                    )
                                )
                            )
                        }
                    } else {
                        emit(
                            BaseResult.Error(
                                LoginGenericResponse().apply {
                                    message = "Login api is failed"
                                }
                            )
                        )
                    }
                }
            } else {
                val jsonAdapter: JsonAdapter<LoginGenericResponse> =
                    moshi.adapter(LoginGenericResponse::class.java)

                authTokenResponse.errorBody()?.let { responseBody ->
                    jsonAdapter.fromJson(responseBody.string())?.let { error ->
                        emit(BaseResult.Error(error))
                    } ?: run {
                        emit(
                            BaseResult.Error(
                                LoginGenericResponse().apply {
                                    message = authTokenResponse.raw().toString()
                                }
                            )
                        )
                    }
                }
            }
        }.catch {
            emit(
                BaseResult.Error(
                    LoginGenericResponse().apply {
                        message = it.message
                    }
                )
            )
        }
    }
}
