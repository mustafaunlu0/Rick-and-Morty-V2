package com.blueplane.ramv2.data.model.dto


data class CharacterModel(
    val id: Int,
    val species: String,
    val gender: String,
    val image: String,
    val type: String,
    val name: String
){
    fun getID() = id.toString()
}