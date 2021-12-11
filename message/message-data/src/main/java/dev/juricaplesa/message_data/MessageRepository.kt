package dev.juricaplesa.message_data

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    fun getMessages(): Flow<Result<Message>>

    suspend fun sendMessage(message: Message): Result<Unit>

}