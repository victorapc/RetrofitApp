package com.inux.retrofitapp.repository

import com.inux.retrofitapp.api.RetrofitInstance
import com.inux.retrofitapp.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}