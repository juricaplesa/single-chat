package dev.juricaplesa.message_data.local

import dev.juricaplesa.core.Result
import dev.juricaplesa.core_data.MessageDao
import dev.juricaplesa.core_data.model.MessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalMessageDataSource(private val messageDao: MessageDao) {

    fun getMessages() = messageDao.getMessages()

    suspend fun insertMessage(messageEntity: MessageEntity): Result<Unit> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                messageDao.insertMessage(messageEntity)
                Result.Success(Unit)
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }

}