package com.inux.retrofitapp.repository

import com.inux.retrofitapp.api.RetrofitInstance
import com.inux.retrofitapp.model.Post

class Repository {
    suspend fun getPost(): Post{
        return RetrofitInstance.api.getPost()
    }
}