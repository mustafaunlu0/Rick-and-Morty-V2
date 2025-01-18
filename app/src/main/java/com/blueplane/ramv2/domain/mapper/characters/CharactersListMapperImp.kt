package com.blueplane.ramv2.domain.mapper.characters

import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.data.model.response.Result
import javax.inject.Inject

class CharactersListMapperImp @Inject constructor() : CharactersListMapper<Result, CharacterModel> {
    override fun map(input: List<Result>? ): List<CharacterModel> {
        return input?.map {
            CharacterModel(
                id = it.id,
                species = it.species,
                name = it.name,
                type = it.type,
                gender = it.gender,
                image = it.image)
        } ?: emptyList()
    }
}