package com.support.delight_assistant.network

import com.support.delight_assistant.core.data.model.DelightRequest
import com.support.delight_assistant.core.data.model.DelightResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("webhook/{webhookUrl}")
    suspend fun connect(@Path("webhookUrl") webhookUrl: String) : String

    @POST("{webhookUrl}")
    suspend fun getDelightResponse(@Body requestBody: DelightRequest, @Path("webhookUrl") webhookUrl: String): Response<DelightResponse>
}