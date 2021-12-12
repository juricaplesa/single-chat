package dev.juricaplesa.messagelist_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.juricaplesa.components.BaseViewModel
import dev.juricaplesa.core.Result
import dev.juricaplesa.message_domain.interactors.GetMessages
import dev.juricaplesa.message_domain.interactors.SendMessage
import dev.juricaplesa.messagelist_ui.model.MessageUI
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MessageListViewModel(
    private val getMessages: GetMessages,
    private val sendMessage: SendMessage
) : BaseViewModel() {

    private val _newMessages = MutableLiveData<List<MessageUI>>()
    val newMessages: LiveData<List<MessageUI>> = _newMessages

    fun getMessages() {
        getMessages.execute().onEach {
            when (it) {
                is Result.Success -> {
                    _newMessages.value = it.data.map { message -> MessageUI(message) }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onSendClick(content: String) {
        viewModelScope.launch {
            sendMessage.execute(content)
        }
    }

}