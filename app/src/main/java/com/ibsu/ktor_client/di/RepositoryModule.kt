package com.ibsu.ktor_client.di

import com.ibsu.ktor_client.data.remote.repository.TheRepositoryImp
import com.ibsu.ktor_client.domain.repository.TheRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: TheRepositoryImp
    ): TheRepository
}
