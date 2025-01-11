package com.blueplane.ramv2.di.usecase

import com.blueplane.ramv2.domain.usecase.GetAllCharactersUseCase
import com.blueplane.ramv2.domain.usecase.GetAllCharactersUseCaseImp
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
}