package com.blueplane.ramv2.domain.usecase.characters

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterModel
import kotlinx.coroutines.flow.Flow

interface GetAllCharactersUseCase {
    operator fun invoke() : Flow<NetworkResponse<List<CharacterModel>>>
}