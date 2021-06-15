package com.inux.retrofitapp.api

import com.inux.retrofitapp.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    // GET -----------------------------------------------------------------------------------------
    // Exemplo de Headers por parâmetro
    @GET("posts/1")
    suspend fun getPost(@Header("Auth") auth: String): Response<Post>

    // Representa por exemplo posts/1
    @GET("posts/{postNumber}")
    suspend fun getPost(@Path("postNumber") number: Int): Response<Post>

    // Representa por exemplo posts
    @Headers(
        "Authorization: 123123123",
        "Plataform: Android"
    )
    @GET("posts")
    suspend fun getListPost(): Response<List<Post>>

    // Representa por exemplo posts?userId=1
    @GET("posts")
    suspend fun getListPost(@Query("userId") userId: Int): Response<List<Post>>

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

    // POST ----------------------------------------------------------------------------------------
    @Headers(
        "Authorization: 123123123",
        "Plataform: Android"
    )
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ) : Response<Post>

    // @FormUrlEncoded irá passar os dados por URL. Ex.: userId=1&id=1&title=Victor&body=Android Retrofit
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ) : Response<Post>
}