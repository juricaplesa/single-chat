package dev.juricaplesa.message_domain.di

import dev.juricaplesa.message_domain.interactors.GetMessages
import dev.juricaplesa.message_domain.interactors.SendMessage
import org.koin.dsl.module

val messageDomainModule = module {

    factory { GetMessages(get()) }
    factory { SendMessage(get()) }

}