package com.support.delight_assistant.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.support.delight_assistant.core.data.model.Context
import com.support.delight_assistant.core.data.model.DelightRequest
import com.support.delight_assistant.core.data.model.DelightResponse
import com.support.delight_assistant.core.data.model.Message
import com.support.delight_assistant.core.data.repository.Repository
import com.support.delight_assistant.utils.Constants.Companion.RECEIVE_ID
import com.support.delight_assistant.utils.Time
import kotlinx.coroutines.launch
import retrofit2.Response

class DelightViewModel(private val repository: Repository): ViewModel() {

    val _messages: MutableLiveData<MutableList<Message>> = MutableLiveData(mutableListOf<Message>())
    val messages: LiveData<MutableList<Message>> = _messages

    val _lastResponse: MutableLiveData<Response<DelightResponse>> = MutableLiveData()
    val lastResponse: LiveData<Response<DelightResponse>> = _lastResponse

    fun getDelightResponse(message : Message, webhookUrl : String) {
        viewModelScope.launch{
            appendMessages(message)
            val request = textToDelightRequest(message.message)
            val response: Response<DelightResponse> = repository.getDelightResponse(request, webhookUrl)
            if (response.isSuccessful) {
                appendMessages(
                    Message(
                        response.body()?.text.toString(),
                        RECEIVE_ID,
                        Time.timeStamp()
                    )
                )
            } else {
                appendMessages(
                    Message(
                        "Check your internet connection",
                        RECEIVE_ID,
                        Time.timeStamp()
                    )
                )
            }
            setLastResponse(response)
        }
    }

    fun setLastResponse(response: Response<DelightResponse>) {
        _lastResponse.value = response
    }

    fun appendMessages(message: Message) {
        _messages.value?.add(message)
    }


    fun textToDelightRequest(text: String) : DelightRequest {
        val deviceId = "6ffc44869276d009"
        val userId = "123456"
        val locale = "en"
        var request = DelightRequest(Context(deviceId, locale, userId), text)
        return request
    }

}