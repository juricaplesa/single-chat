package dev.juricaplesa.message_domain.interactors

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_domain.MessageRepository

class GetPreviousMessages(
    private val repository: MessageRepository
) {

    suspend fun execute(): Result<List<Message>> {
        return repository.getPreviousMessages()
    }

}