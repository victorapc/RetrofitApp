package com.inux.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.inux.retrofitapp.adapter.MyAdapter
import com.inux.retrofitapp.model.Post
import com.inux.retrofitapp.repository.Repository
import com.inux.retrofitapp.viewmodel.MainViewModel
import com.inux.retrofitapp.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {
        MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //val options: HashMap<String, String> = HashMap()
        //options.put("_sort", "id")
        //options.put("_order", "desc")
        //Ou
        //options["_sort"] = "id"
        //options["_order"] = "desc"

        viewModel.getListPost()

        viewModel.myListResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun addPost(){
        val myPost = Post(2, 2, "Victor", "Android Retrofit")

        viewModel.pushPost(myPost)
        //viewModel.pushPost(2, 2, "Victor", "Android Retrofit")
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString())
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add  ->
                addPost()
            else -> false
        }
        return super.onOptionsItemSelected(item)
    }
}