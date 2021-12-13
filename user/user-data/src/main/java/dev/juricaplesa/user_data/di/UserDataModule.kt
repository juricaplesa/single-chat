package dev.juricaplesa.user_data.di

import dev.juricaplesa.user_data.UserRepositoryImpl
import org.koin.dsl.module

val userDataModule = module {

    single { UserRepositoryImpl() }

}