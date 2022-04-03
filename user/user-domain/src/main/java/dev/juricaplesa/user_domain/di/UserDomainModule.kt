package dev.juricaplesa.user_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.juricaplesa.user_domain.UserRepository
import dev.juricaplesa.user_domain.interactors.GetLoggedUserId
import dev.juricaplesa.user_domain.interactors.SwitchLoggedUser

@Module
@InstallIn(SingletonComponent::class)
object UserDomainModule {

    @Provides
    fun provideGetLoggedUserId(userRepository: UserRepository): GetLoggedUserId {
        return GetLoggedUserId(userRepository)
    }

    @Provides
    fun provideSwitchLoggedUser(userRepository: UserRepository): SwitchLoggedUser {
        return SwitchLoggedUser(userRepository)
    }

}