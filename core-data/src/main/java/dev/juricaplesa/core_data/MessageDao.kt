package dev.juricaplesa.core_data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.juricaplesa.core_data.common.MESSAGES_COLUMN_SENDER_ID
import dev.juricaplesa.core_data.common.MESSAGES_COLUMN_TIME_SENT
import dev.juricaplesa.core_data.common.MESSAGES_TABLE_NAME
import dev.juricaplesa.core_data.model.MessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM $MESSAGES_TABLE_NAME ORDER BY $MESSAGES_COLUMN_TIME_SENT DESC")
    fun getPreviousMessages(): List<MessageEntity>

    @Query("SELECT * FROM $MESSAGES_TABLE_NAME ORDER BY $MESSAGES_COLUMN_TIME_SENT DESC LIMIT 1")
    fun getNewMessages(): Flow<MessageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(messageEntity: MessageEntity)

}