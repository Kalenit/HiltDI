package com.example.hiltcarengine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module // creates a container to return instances of class
@InstallIn(SingletonComponent::class)
object EngineModule {


    @Provides
    @Singleton
    fun provideEngine(): Engine = DieselEngine()

}