package com.blueplane.ramv2.di.mapper

import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.data.model.response.Result
import com.blueplane.ramv2.domain.mapper.CharactersListMapper
import com.blueplane.ramv2.domain.mapper.CharactersListMapperImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindCharactersListMapper(
        charactersListMapperImp: CharactersListMapperImp
    ): CharactersListMapper<Result, CharacterModel>

}