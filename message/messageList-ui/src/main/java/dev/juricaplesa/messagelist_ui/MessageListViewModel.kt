package dev.juricaplesa.messagelist_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.juricaplesa.components.BaseViewModel
import dev.juricaplesa.components.Event
import dev.juricaplesa.core.Result
import dev.juricaplesa.message_domain.interactors.GetNewMessages
import dev.juricaplesa.message_domain.interactors.GetPreviousMessages
import dev.juricaplesa.message_domain.interactors.SendMessage
import dev.juricaplesa.messagelist_ui.model.MessageUI
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MessageListViewModel(
    private val getPreviousMessages: GetPreviousMessages,
    private val getNewMessages: GetNewMessages,
    private val sendMessage: SendMessage
) : BaseViewModel() {

    private val _previousMessages = MutableLiveData<List<MessageUI>>()
    val previousMessages: LiveData<List<MessageUI>> = _previousMessages

    private val _newMessages = MutableLiveData<MessageUI>()
    val newMessages: LiveData<MessageUI> = _newMessages

    fun getPreviousMessages() {
        viewModelScope.launch {
            val result = getPreviousMessages.execute()
            when(result) {
                is Result.Success -> _previousMessages.value = result.data.map { message -> MessageUI(message) }
                is Result.Error -> _errorMessage.value = Event(R.string.error_general)
            }
        }
    }

    fun getNewMessages() {
        getNewMessages.execute().onEach {
            when (it) {
                is Result.Success -> {
                    _newMessages.value = MessageUI(it.data)
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