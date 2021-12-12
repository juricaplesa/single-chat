package dev.juricaplesa.messagelist_ui.model

import dev.juricaplesa.core.model.Message

data class MessageUI(
    var content: String
) {

    constructor(message: Message) : this(message.content)

}