package dev.juricaplesa.message_domain.interactors

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_domain.MessageRepository
import dev.juricaplesa.user_domain.interactors.GetLoggedUserId
import java.util.*

class SendMessage(
    private val messageRepository: MessageRepository,
    private val getLoggedUserId: GetLoggedUserId
) {

    suspend fun execute(content: String): Result<Unit> {
        val senderId = getLoggedUserId.execute()
        return messageRepository.sendMessage(
            Message(
                UUID.randomUUID().toString(),
                senderId,
                content,
                Calendar.getInstance().timeInMillis
            )
        )
    }

}