package com.umutcansahin.rickmorty.di

import com.umutcansahin.rickmorty.common.Constants
import com.umutcansahin.rickmorty.data.remote.RickMortyApi
import com.umutcansahin.rickmorty.data.repository.RickMortyRepositoryImpl
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickMortyApi(): RickMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickMortyRepository(api: RickMortyApi): RickMortyRepository {
        return RickMortyRepositoryImpl(api)
    }

}