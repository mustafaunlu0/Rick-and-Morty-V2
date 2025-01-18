package com.blueplane.ramv2.domain.usecase.characters.character

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterDetailModel
import com.blueplane.ramv2.data.model.response.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface GetSpecialCharacterUseCase {
    operator fun invoke(id : String) : Flow<NetworkResponse<CharacterDetailModel>>
}