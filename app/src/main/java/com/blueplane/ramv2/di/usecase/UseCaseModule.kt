package com.blueplane.ramv2.di.usecase

import com.blueplane.ramv2.domain.usecase.character.GetSpecialCharacterUseCaseImp
import com.blueplane.ramv2.domain.usecase.characters.GetAllCharactersUseCase
import com.blueplane.ramv2.domain.usecase.characters.GetAllCharactersUseCaseImp
import com.blueplane.ramv2.domain.usecase.characters.character.GetSpecialCharacterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCharactersUseCase(
        getAllCharactersUseCaseImp: GetAllCharactersUseCaseImp
    ): GetAllCharactersUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSpecialCharacterUseCase(
        getSpecialCharacterUseCaseImp: GetSpecialCharacterUseCaseImp
    ) : GetSpecialCharacterUseCase

}