package com.example.cinergy.data.login.api

import com.example.cinergy.data.login.dto.AuthTokenRequestDto
import com.example.cinergy.data.login.dto.AuthTokenResponseDto
import com.example.cinergy.data.login.dto.LoginRequestDto
import com.example.cinergy.data.login.dto.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface LoginApi {

    @POST("https://cinergyapp.thetunagroup.com/api/guestToken")
    suspend fun getGuestToken(@Body authTokenRequestDto: AuthTokenRequestDto): Response<AuthTokenResponseDto>

    @POST("https://cinergyapp.thetunagroup.com/api/login")
    suspend fun getLogin(
        @HeaderMap headers: Map<String, String>,
        @Body loginRequestDto: LoginRequestDto
    ): Response<LoginResponseDto>
}