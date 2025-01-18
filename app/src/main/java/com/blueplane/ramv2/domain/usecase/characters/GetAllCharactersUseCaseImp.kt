package com.blueplane.ramv2.domain.usecase.characters

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.data.model.response.Result
import com.blueplane.ramv2.data.repository.CharacterRepository
import com.blueplane.ramv2.domain.mapper.characters.CharactersListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCharactersUseCaseImp @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val mapper: CharactersListMapper<Result, CharacterModel>
) : GetAllCharactersUseCase {
    override fun invoke(): Flow<NetworkResponse<List<CharacterModel>>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = characterRepository.getAllCharacters()) {
                is NetworkResponse.Success -> {
                    emit(NetworkResponse.Success(mapper.map(response.data?.results)))
                }

                is NetworkResponse.Error -> {
                    emit(NetworkResponse.Error(response.error))
                }

                NetworkResponse.Loading -> Unit
            }
        }

}