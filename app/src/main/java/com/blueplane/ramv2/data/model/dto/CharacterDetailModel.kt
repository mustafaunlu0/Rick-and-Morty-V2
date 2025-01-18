package com.blueplane.ramv2.data.model.dto

import com.blueplane.ramv2.data.model.response.Location
import com.blueplane.ramv2.data.model.response.Origin

data class CharacterDetailModel (
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
)