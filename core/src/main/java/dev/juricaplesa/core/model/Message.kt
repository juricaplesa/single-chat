package dev.juricaplesa.core.model

data class Message(
    var id: String,
    var senderId: String,
    var content: String,
    val timeSent: Long
)
