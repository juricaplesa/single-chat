package dev.juricaplesa.user_domain.di

import dev.juricaplesa.user_domain.interactors.GetLoggedUserId
import dev.juricaplesa.user_domain.interactors.SwitchLoggedUser
import org.koin.dsl.module

val userDomainModule = module {

    factory { GetLoggedUserId(get()) }
    factory { SwitchLoggedUser(get()) }

}