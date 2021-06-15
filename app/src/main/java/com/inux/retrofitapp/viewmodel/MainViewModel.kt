package com.inux.retrofitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inux.retrofitapp.model.Post
import com.inux.retrofitapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myListResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    // GET -----------------------------------------------------------------------------------------
    fun getPost(auth: String){
        viewModelScope.launch {
            val response = repository.getPost(auth)
            myResponse.value = response
        }
    }

    fun getPost(number: Int){
        viewModelScope.launch {
            val response = repository.getPost(number)
            myResponse.value = response
        }
    }

    fun getListPost(){
        viewModelScope.launch {
            val response = repository.getListPost()
            myListResponse.value = response
        }
    }

    fun getListPost(userId: Int){
        viewModelScope.launch {
            val response = repository.getListPost(userId)
            myListResponse.value = response
        }
    }

    fun getListPost(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getListPost(userId, sort, order)
            myListResponse.value = response
        }
    }

    fun getListPost(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getListPost(userId, options)
            myListResponse.value = response
        }
    }

    // POST ----------------------------------------------------------------------------------------
    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost(userId: Int, id: Int, title: String, body: String){
        viewModelScope.launch {
            val response = repository.pushPost(userId, id, title, body)
            myResponse.value = response
        }
    }
}