package dev.juricaplesa.message_domain.di

import dev.juricaplesa.message_domain.interactors.GetNewMessages
import dev.juricaplesa.message_domain.interactors.GetPreviousMessages
import dev.juricaplesa.message_domain.interactors.SendMessage
import org.koin.dsl.module

val messageDomainModule = module {

    factory { GetPreviousMessages(get()) }
    factory { GetNewMessages(get()) }
    factory { SendMessage(get()) }

}