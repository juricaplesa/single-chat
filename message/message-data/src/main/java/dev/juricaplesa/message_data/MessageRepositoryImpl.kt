package dev.juricaplesa.message_data

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.core_data.model.MessageEntity
import dev.juricaplesa.message_data.local.LocalMessageDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map

class MessageRepositoryImpl(private val localMessageDataSource: LocalMessageDataSource) :
    dev.juricaplesa.message_domain.MessageRepository {

    override suspend fun getPreviousMessages(): Result<List<Message>> {
        return when(val queryResult = localMessageDataSource.getPreviousMessages()) {
            is Result.Success -> Result.Success(queryResult.data.map { it.toMessage() })
            is Result.Error -> Result.Error(queryResult.exception)
        }
    }

    override fun getNewMessages(): Flow<Result<Message>> {
        return localMessageDataSource.getNewMessages().drop(1).map { value -> Result.Success(value.toMessage()) }
    }

    override suspend fun sendMessage(message: Message) =
        localMessageDataSource.insertMessage(MessageEntity(message))

}