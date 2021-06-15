package com.inux.retrofitapp.repository

import com.inux.retrofitapp.api.RetrofitInstance
import com.inux.retrofitapp.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost(number)
    }

    suspend fun getListPost(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getListPost(userId, sort, order)
    }

    suspend fun getListPost(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getListPost(userId, options)
    }
}