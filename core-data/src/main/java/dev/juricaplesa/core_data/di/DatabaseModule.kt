package dev.juricaplesa.core_data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.juricaplesa.core_data.Database
import dev.juricaplesa.core_data.MessageDao
import javax.inject.Singleton

private const val DATABASE_NAME = "database"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): Database {
        return Room.databaseBuilder(applicationContext, Database::class.java, DATABASE_NAME)
            .build()
    }

    @Provides
    fun provideMessageDao(database: Database): MessageDao {
        return database.messageDao()
    }

}