package com.blueplane.ramv2.domain.usecase

import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.dto.CharacterDTO
import com.blueplane.ramv2.data.model.response.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface GetAllCharactersUseCase {
    operator fun invoke() : Flow<NetworkResponse<List<CharacterDTO>>>
}