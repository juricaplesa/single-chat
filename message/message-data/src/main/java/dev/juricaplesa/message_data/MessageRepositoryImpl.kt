package dev.juricaplesa.message_data

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_data.local.LocalMessageDataSource
import kotlinx.coroutines.flow.Flow

class MessageRepositoryImpl(localMessageDataSource: LocalMessageDataSource) : MessageRepository {

    override fun getMessages(): Flow<Result<Message>> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(message: Message): Result<Unit> {
        TODO("Not yet implemented")
    }

}