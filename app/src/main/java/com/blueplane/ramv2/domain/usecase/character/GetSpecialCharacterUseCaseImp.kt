package com.blueplane.ramv2.domain.usecase.character

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterDetailModel
import com.blueplane.ramv2.data.model.response.CharacterResponse
import com.blueplane.ramv2.data.repository.CharacterRepository
import com.blueplane.ramv2.domain.mapper.character.CharacterMapper
import com.blueplane.ramv2.domain.mapper.character.CharacterMapperImp
import com.blueplane.ramv2.domain.usecase.characters.character.GetSpecialCharacterUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSpecialCharacterUseCaseImp @Inject constructor(
    private val repository: CharacterRepository,
    private val charMapper : CharacterMapper<CharacterResponse, CharacterDetailModel>
) : GetSpecialCharacterUseCase {
    override fun invoke(id: String): Flow<NetworkResponse<CharacterDetailModel>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = repository.getSpecialCharacter(id)) {
                is NetworkResponse.Success -> {
                    emit(NetworkResponse.Success(charMapper.map(response.data)))
                }

                is NetworkResponse.Error -> {
                    emit(NetworkResponse.Error(response.error))
                }

                NetworkResponse.Loading -> {
                    emit(NetworkResponse.Loading)
                }
            }
        }

}