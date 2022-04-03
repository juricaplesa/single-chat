package dev.juricaplesa.message_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.juricaplesa.message_domain.MessageRepository
import dev.juricaplesa.message_domain.interactors.GetNewMessages
import dev.juricaplesa.message_domain.interactors.GetPreviousMessages
import dev.juricaplesa.message_domain.interactors.SendMessage
import dev.juricaplesa.user_domain.UserRepository
import dev.juricaplesa.user_domain.interactors.GetLoggedUserId

@Module
@InstallIn(SingletonComponent::class)
object MessageDomainModule {

    @Provides
    fun provideGetPreviousMessages(messageRepository: MessageRepository): GetPreviousMessages {
        return GetPreviousMessages(messageRepository)
    }

    @Provides
    fun provideGetNewMessages(messageRepository: MessageRepository): GetNewMessages {
        return GetNewMessages(messageRepository)
    }

    @Provides
    fun provideSendMessage(
        messageRepository: MessageRepository,
        getLoggedUserId: GetLoggedUserId
    ): SendMessage {
        return SendMessage(messageRepository, getLoggedUserId)
    }

}