package dev.juricaplesa.message_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.juricaplesa.core_data.MessageDao
import dev.juricaplesa.message_data.MessageRepositoryImpl
import dev.juricaplesa.message_data.local.LocalMessageDataSource
import dev.juricaplesa.message_domain.MessageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MessageDataModule {

    @Provides
    @Singleton
    fun provideLocalMessageDataSource(messageDao: MessageDao): LocalMessageDataSource {
        return LocalMessageDataSource(messageDao)
    }

    @Provides
    fun provideMessageRepository(localMessageDataSource: LocalMessageDataSource): MessageRepository {
        return MessageRepositoryImpl(localMessageDataSource)
    }

}