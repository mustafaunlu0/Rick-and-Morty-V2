package com.blueplane.ramv2.domain.mapper

interface CharactersListMapper <I, O> {
    fun map(input: List<I>?): List<O>
}