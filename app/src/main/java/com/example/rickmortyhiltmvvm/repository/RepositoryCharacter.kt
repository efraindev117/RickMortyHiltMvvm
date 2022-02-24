package com.example.rickmortyhiltmvvm.repository

import com.example.rickmortyhiltmvvm.API.ServiceCharacter
import javax.inject.Inject

class RepositoryCharacter @Inject constructor(private val api : ServiceCharacter){
    suspend fun getAllImage() =api.getAllCharacter()

}