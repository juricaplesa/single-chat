package dev.juricaplesa.message_domain.interactors

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_domain.MessageRepository
import java.util.*

class SendMessage(
    private val repository: MessageRepository
) {

    suspend fun execute(content: String): Result<Unit> {
        return repository.sendMessage(Message(UUID.randomUUID().toString(), "", content, Calendar.getInstance().timeInMillis))
    }

}