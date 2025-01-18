package com.blueplane.ramv2.domain.mapper.character

interface CharacterMapper <I, O> {
    fun map(input: I?): O?
}