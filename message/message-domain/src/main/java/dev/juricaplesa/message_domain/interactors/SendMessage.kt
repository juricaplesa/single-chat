package dev.juricaplesa.message_domain.interactors

import dev.juricaplesa.core.Result
import dev.juricaplesa.core.model.Message
import dev.juricaplesa.message_domain.MessageRepository
import dev.juricaplesa.user_domain.UserRepository
import java.util.*

class SendMessage(
    private val messageRepository: MessageRepository,
    private val userRepository: UserRepository
) {

    suspend fun execute(content: String): Result<Unit> {
        val senderId = userRepository.getLoggedUserId()
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