package com.support.delight_assistant.core.data.model

data class DelightRequest(
    val context: Context,
    val text: String
)

data class Context(
    val deviceId: String,
    val locale: String,
    val userId: String
)