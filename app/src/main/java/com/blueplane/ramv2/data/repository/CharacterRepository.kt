package com.blueplane.ramv2.data.repository

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.response.CharacterResponse

interface CharacterRepository {

    suspend fun getAllCharacters() : NetworkResponse<CharacterResponse>
}