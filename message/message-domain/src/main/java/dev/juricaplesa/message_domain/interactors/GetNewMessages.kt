package dev.juricaplesa.message_domain.interactors

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_domain.MessageRepository
import kotlinx.coroutines.flow.Flow

class GetNewMessages(
    private val repository: MessageRepository
) {

    fun execute(): Flow<Result<Message>> {
        return repository.getNewMessages()
    }

}