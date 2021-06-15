package com.inux.retrofitapp.api

import com.inux.retrofitapp.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    // Representa por exemplo posts/1
    @GET("posts/{postNumber}")
    suspend fun getPost(@Path("postNumber") number: Int): Response<Post>

    // Representa por exemplo posts?userId=1
    @GET("posts")
    suspend fun getListPost(@Query("userId") userId: Int,
    ): Response<List<Post>>

    // Representa por exemplo posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    suspend fun getListPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    // Representa por exemplo posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    suspend fun getListPost(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>
}