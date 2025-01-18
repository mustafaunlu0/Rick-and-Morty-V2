package com.blueplane.ramv2.data.repository

import com.blueplane.ramv2.data.api.ApiService
import com.blueplane.ramv2.data.api.utils.safeApiCall
import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.response.CharacterResponse
import com.blueplane.ramv2.data.model.response.CharactersResponse
import com.blueplane.ramv2.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : CharacterRepository {

    override suspend fun getAllCharacters(): NetworkResponse<CharactersResponse> =
         withContext(ioDispatcher){
            safeApiCall { apiService.getCharacters()  }
        }

    override suspend fun getSpecialCharacter(id: String): NetworkResponse<CharacterResponse> =
        withContext(ioDispatcher){
            safeApiCall { apiService.getSpecialCharacter(id) }
        }


}