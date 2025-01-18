package com.blueplane.ramv2.data.repository

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.response.CharacterResponse
import com.blueplane.ramv2.data.model.response.CharactersResponse

interface CharacterRepository {

    suspend fun getAllCharacters() : NetworkResponse<CharactersResponse>

    suspend fun getSpecialCharacter(id : String) : NetworkResponse<CharacterResponse>
}