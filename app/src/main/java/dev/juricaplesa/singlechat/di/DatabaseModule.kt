package dev.juricaplesa.singlechat.di

import androidx.room.Room
import dev.juricaplesa.singlechat.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "database"

val databaseModule = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java, DATABASE_NAME)
            .build()
    }

    factory { get<Database>().messageDao() }

}