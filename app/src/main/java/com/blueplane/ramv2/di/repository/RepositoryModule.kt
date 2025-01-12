package com.blueplane.ramv2.di.repository

import com.blueplane.ramv2.data.repository.CharacterRepository
import com.blueplane.ramv2.data.repository.CharacterRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {



    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: CharacterRepositoryImp): CharacterRepository

}