package com.blueplane.ramv2.di.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object CoroutineModule {

    @IoDispatcher
    @Provides
    @ViewModelScoped
    fun provideIoDispatcher() = Dispatchers.IO


}