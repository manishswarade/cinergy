package com.example.cinergy.domain.login.model

import com.example.cinergy.data.login.dto.AuthTokenRequestDto
import com.example.cinergy.data.login.dto.LoginRequestDto

data class AuthTokenRequest(
    val secretKey: String,
    val deviceType: String,
    val deviceId: String,
    val pushToken: String,
    val loginType: String
)


fun AuthTokenRequest.toAuthTokenRequestDto(): AuthTokenRequestDto {
    return AuthTokenRequestDto(
        secretKey = this.secretKey,
        deviceType = this.deviceType,
        deviceId = this.deviceId,
        pushToken = this.pushToken
    )
}

fun AuthTokenRequest.toLoginRequestDto(): LoginRequestDto {
    return LoginRequestDto(
        deviceType = this.deviceType,
        deviceId = this.deviceId,
        loginType = this.loginType
    )
}