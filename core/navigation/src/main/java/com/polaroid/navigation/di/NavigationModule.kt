package com.polaroid.navigation.di

import com.polaroid.navigation.INavigationManager
import com.polaroid.navigation.NavigationManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Singleton
    @Binds
    abstract fun navigationManager(navigator: NavigationManager): INavigationManager
}
