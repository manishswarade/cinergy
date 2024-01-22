package com.example.cinergy.data.common.util

object AppConstant {

    const val UUID_TYPE5_KEY = "Cinergy"
    const val DEVICE_ID_PREFIX = "CI -"
    const val AUTHORIZATION_HEADER_TAG = "Authorization"
    const val BEARER = "Bearer "

    //TOTO: WE will move this field to keystore
    private val SECRET_KEY = "402620C92552D9303C58B901B43B0A41718E772C19520DD9A9AA52CE5A8FCB99"
    private var memberId = ""
    private var locationId = ""
    private var token = ""

    fun getSecretKey(): String {
        return SECRET_KEY
    }

    fun setLocationId(locationId: String) {
        this.locationId = locationId
    }

    fun setToken(token: String) {
        this.token = token
    }

    fun setMemberId(memberId: String) {
        this.memberId = memberId
    }

    fun getLocationId(): String {
        return this.locationId
    }

    fun getToken(): String {
        return this.token
    }

    fun getMemberId(): String {
        return this.memberId
    }
}
