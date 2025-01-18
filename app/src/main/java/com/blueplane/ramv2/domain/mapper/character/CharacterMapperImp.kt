package com.blueplane.ramv2.domain.mapper.character

import com.blueplane.ramv2.data.model.dto.CharacterDetailModel
import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.data.model.response.CharacterResponse
import javax.inject.Inject

class CharacterMapperImp @Inject constructor() :CharacterMapper<CharacterResponse, CharacterDetailModel> {
    override fun map(input: CharacterResponse?): CharacterDetailModel? {
        return input?.let {
            CharacterDetailModel(
            it.id,
                it.name,
                it.gender,
                it.image,
                it.location,
                it.origin,
                it.species,
                it.status)
        }
    }
}