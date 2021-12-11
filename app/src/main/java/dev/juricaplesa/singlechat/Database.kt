package dev.juricaplesa.singlechat

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.juricaplesa.message_data.local.MessageDao
import dev.juricaplesa.message_data.local.model.MessageEntity

@Database(entities = [MessageEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun messageDao(): MessageDao

}