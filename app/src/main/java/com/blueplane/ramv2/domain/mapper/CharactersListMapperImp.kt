package com.blueplane.ramv2.domain.mapper

import com.blueplane.ramv2.data.model.dto.CharacterDTO
import com.blueplane.ramv2.data.model.response.CharacterResponse
import com.blueplane.ramv2.data.model.response.Result

class CharactersListMapperImp : CharactersListMapper<Result, CharacterDTO> {
    override fun map(input: List<Result>? ): List<CharacterDTO> {
        return input?.map {
            CharacterDTO(
                id = it.id,
                species = it.species,
                name = it.name,
                type = it.type,
                gender = it.gender,
                image = it.image)
        } ?: emptyList()
    }
}