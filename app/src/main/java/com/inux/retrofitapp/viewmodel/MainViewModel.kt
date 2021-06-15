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

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost(number: Int){
        viewModelScope.launch {
            val response = repository.getPost(number)
            myResponse.value = response
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
}