package com.example.cinergy.data.login.module

import com.example.cinergy.data.login.api.LoginApi
import com.example.cinergy.data.login.repository.LoginRepositoryImpl
import com.example.cinergy.domain.login.repository.LoginRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module(includes = [com.example.cinergy.data.common.networkModule.NetworkModule::class])
@InstallIn(SingletonComponent::class)
class LoginModule {
    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(
        loginApi: LoginApi,
        moshi: Moshi
    ): LoginRepository {
        return LoginRepositoryImpl(loginApi, moshi)
    }
}
