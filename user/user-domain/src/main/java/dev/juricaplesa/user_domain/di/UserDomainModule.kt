package dev.juricaplesa.user_domain.di

import dev.juricaplesa.user_domain.interactors.SwitchUser
import org.koin.dsl.module

val userDomainModule = module {

    factory { SwitchUser(get()) }

}