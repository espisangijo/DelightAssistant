package com.support.delight_assistant.core.data.repository

import com.support.delight_assistant.core.data.model.DelightRequest
import com.support.delight_assistant.core.data.model.DelightResponse
import com.support.delight_assistant.core.data.network.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun connect(webhookUrl : String) : String {
        return RetrofitInstance.api.connect(webhookUrl)
    }
    suspend fun getDelightResponse(requestBody : DelightRequest, webhookUrl : String) : Response<DelightResponse> {
        return RetrofitInstance.api.getDelightResponse(requestBody, webhookUrl)
    }
}