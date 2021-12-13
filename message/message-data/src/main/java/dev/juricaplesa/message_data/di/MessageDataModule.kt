package dev.juricaplesa.message_data.di

import dev.juricaplesa.message_domain.MessageRepository
import dev.juricaplesa.message_data.MessageRepositoryImpl
import dev.juricaplesa.message_data.local.LocalMessageDataSource
import org.koin.dsl.module

val messageDataModule = module {

    single { LocalMessageDataSource(get()) }

    factory<MessageRepository> { MessageRepositoryImpl(LocalMessageDataSource(get())) }

}