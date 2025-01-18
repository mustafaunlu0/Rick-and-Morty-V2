package com.blueplane.ramv2.data.api

import com.blueplane.ramv2.data.model.response.CharacterResponse
import com.blueplane.ramv2.data.model.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters() :CharactersResponse

    @GET("character/{characterNumber}")
    suspend fun getSpecialCharacter(@Path("characterNumber") characterNumber :String) : CharacterResponse

}