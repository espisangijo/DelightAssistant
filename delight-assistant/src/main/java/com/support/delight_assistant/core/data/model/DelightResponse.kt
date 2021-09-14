package com.support.delight_assistant.core.data.model

data class DelightResponse(
    val helperIntent: HelperIntent,
    val shouldEndConversation: Boolean,
    val text: String
)

data class HelperIntent(
    val name: String
)