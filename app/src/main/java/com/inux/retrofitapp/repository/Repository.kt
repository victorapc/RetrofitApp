package com.inux.retrofitapp.repository

import com.inux.retrofitapp.api.RetrofitInstance
import com.inux.retrofitapp.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(auth: String): Response<Post> {
        return RetrofitInstance.api.getPost(auth)
    }

    suspend fun getPost(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost(number)
    }

    suspend fun getListPost(): Response<List<Post>> {
        return RetrofitInstance.api.getListPost()
    }

    suspend fun getListPost(userId: Int): Response<List<Post>> {
        return RetrofitInstance.api.getListPost(userId)
    }

    suspend fun getListPost(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getListPost(userId, sort, order)
    }

    suspend fun getListPost(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getListPost(userId, options)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost(userId: Int, id: Int, title: String, body: String): Response<Post> {
        return RetrofitInstance.api.pushPost(userId, id, title, body)
    }
}