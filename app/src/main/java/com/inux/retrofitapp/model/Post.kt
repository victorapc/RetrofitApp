package com.inux.retrofitapp.model

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
