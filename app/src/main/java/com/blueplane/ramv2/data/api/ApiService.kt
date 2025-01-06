package com.blueplane.ramv2.data.api

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.response.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters() :CharacterResponse

}