package com.example.cinergy.data.movieList.module

import com.example.cinergy.data.movieList.api.MovieListApi
import com.example.cinergy.data.movieList.repository.MovieRepositoryImpl
import com.example.cinergy.domain.movieList.repository.MovieListRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module(includes = [com.example.cinergy.data.common.networkModule.NetworkModule::class])
@InstallIn(SingletonComponent::class)
class MovieListModule {
    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit): MovieListApi {
        return retrofit.create(MovieListApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(
        escapeMovieListApi: MovieListApi,
        moshi: Moshi
    ): MovieListRepository {
        return MovieRepositoryImpl(escapeMovieListApi, moshi)
    }
}
