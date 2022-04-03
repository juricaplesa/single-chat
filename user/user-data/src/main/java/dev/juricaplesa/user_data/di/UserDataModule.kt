package dev.juricaplesa.user_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.juricaplesa.user_data.UserRepositoryImpl
import dev.juricaplesa.user_domain.UserRepository

@Module
@InstallIn(SingletonComponent::class)
object UserDataModule {

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }

}