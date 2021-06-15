package com.inux.retrofitapp.api

import com.inux.retrofitapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("todos/1")
    suspend fun getPost(): Response<Post>

}