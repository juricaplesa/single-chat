package dev.juricaplesa.message_data

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.core_data.model.MessageEntity
import dev.juricaplesa.message_data.local.LocalMessageDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepositoryImpl(private val localMessageDataSource: LocalMessageDataSource) :
    MessageRepository {

    override fun getMessages(): Flow<Result<List<Message>>> {
        return localMessageDataSource.getMessages().map { value -> Result.Success(value.map { it.toMessage() }) }
    }

    override suspend fun sendMessage(message: Message) =
        localMessageDataSource.insertMessage(MessageEntity(message.id, message.senderId, message.content, message.timeSent))

}