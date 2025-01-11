package com.blueplane.ramv2.domain.usecase

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterDTO
import com.blueplane.ramv2.data.model.response.Result
import com.blueplane.ramv2.data.repository.CharacterRepository
import com.blueplane.ramv2.domain.mapper.CharactersListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCharactersUseCaseImp @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val mapper: CharactersListMapper<Result,CharacterDTO>
) : GetAllCharactersUseCase {
    override fun invoke(): Flow<NetworkResponse<List<CharacterDTO>>> {
        return flow {
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
}