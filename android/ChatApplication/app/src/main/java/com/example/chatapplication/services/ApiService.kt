package com.example.chatapplication.services

import com.example.chatapplication.models.Chat
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/json.php")
    fun fetchAllChats(): Call<List<Chat>>
}