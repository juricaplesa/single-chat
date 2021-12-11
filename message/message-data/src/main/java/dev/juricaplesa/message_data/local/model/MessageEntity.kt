package dev.juricaplesa.message_data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_data.local.common.*

@Entity(tableName = MESSAGES_TABLE_NAME)
data class MessageEntity(
    @PrimaryKey @ColumnInfo(name = MESSAGES_COLUMN_ID) var id: String,
    @ColumnInfo(name = MESSAGES_COLUMN_SENDER_ID) var senderId: String,
    @ColumnInfo(name = MESSAGES_COLUMN_CONTENT) var content: String,
    @ColumnInfo(name = MESSAGES_COLUMN_TIME_SENT) var timeSent: Long,
) {

    fun toMessage() = Message(id, senderId, content, timeSent)

}