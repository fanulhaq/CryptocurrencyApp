package com.muchi.cryptocurrency.di

import com.muchi.cryptocurrency.data.remote.CoinPaprikaApi
import com.muchi.cryptocurrency.data.repository.CoinRepositoryImpl
import com.muchi.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}