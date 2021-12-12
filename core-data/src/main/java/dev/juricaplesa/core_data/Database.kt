package dev.juricaplesa.core_data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.juricaplesa.core_data.model.MessageEntity

@Database(entities = [MessageEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun messageDao(): MessageDao

}