package dev.juricaplesa.message_domain

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    /**
     * Returns list of previous messages
     */
    suspend fun getPreviousMessages(): Result<List<Message>>

    /**
     * Returns flow which emits latest received message
     */
    fun getNewMessages(): Flow<Result<Message>>

    /**
     * Sends message
     *
     * @param message message to be sent
     *
     */
    suspend fun sendMessage(message: Message): Result<Unit>

}