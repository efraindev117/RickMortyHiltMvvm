package com.example.rickmortyhiltmvvm.API

import com.example.rickmortyhiltmvvm.constants.Constants.END_POINT
import com.example.rickmortyhiltmvvm.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceCharacter {
    @GET(END_POINT)
    suspend fun getAllCharacter(): Response<CharacterResponse>
}