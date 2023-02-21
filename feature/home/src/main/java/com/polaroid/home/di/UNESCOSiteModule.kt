package com.polaroid.home.di

import android.content.Context
import android.content.res.AssetManager
import com.polaroid.home.data.RepositoryImpl
import com.polaroid.home.data.datasource.LocalDatasource
import com.polaroid.home.data.datasource.LocalDatasourceImpl
import com.polaroid.home.domain.repo.UNESCOSiteRepository
import com.polaroid.home.domain.usecase.GetUNESCOSiteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class NormalAssetManager

@Module
@InstallIn(SingletonComponent::class)
object UNESCOSiteModule {

    @Singleton
    @Provides
    fun provideRepository(
        localDatasource: LocalDatasource
    ): UNESCOSiteRepository {
        return RepositoryImpl(localDatasource = localDatasource)
    }

    @Singleton
    @Provides
    fun providesLocalData(@NormalAssetManager assetManager: AssetManager): LocalDatasource {
        return LocalDatasourceImpl(assetManager = assetManager)
    }

    @Singleton
    @Provides
    fun providesUNESCOSiteUseCase(repository: UNESCOSiteRepository): GetUNESCOSiteUseCase {
        return GetUNESCOSiteUseCase(repository)
    }

    @NormalAssetManager
    @Singleton
    @Provides
    fun provideAssetManager(@ApplicationContext context: Context): AssetManager {
        return context.assets
    }

}
