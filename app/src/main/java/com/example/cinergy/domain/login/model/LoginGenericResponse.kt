package com.example.cinergy.domain.login.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginGenericResponse(
    @Json(name = "statusCode") var statusCode: Int? = null,
    @Json(name = "status") var status: String? = null,
    @Json(name = "message") var message: String? = null,
    @Json(name = "error") var error: Error? = null
)
