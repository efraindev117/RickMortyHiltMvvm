package com.example.rickmortyhiltmvvm.dependencyInjection

import com.example.rickmortyhiltmvvm.API.ServiceCharacter
import com.example.rickmortyhiltmvvm.constants.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    fun providesBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance() : ServiceCharacter =
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceCharacter::class.java)

}