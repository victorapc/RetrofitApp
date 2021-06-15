package com.inux.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.inux.retrofitapp.repository.Repository
import com.inux.retrofitapp.viewmodel.MainViewModel
import com.inux.retrofitapp.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val options: HashMap<String, String> = HashMap()
        options.put("_sort", "id")
        options.put("_order", "desc")
        //Ou
        //options["_sort"] = "id"
        //options["_order"] = "desc"

        button.setOnClickListener {
            val number =  Integer.parseInt(number_EditText.text.toString())
            viewModel.getListPost(number, options)

            viewModel.myListResponse.observe(this, Observer { response ->
                if(response.isSuccessful){
                    textView.text = response.body()?.toString()
                    response.body()?.forEach {
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                    }
                }else{
                    textView.text = response.code().toString()
                }
            })
        }
    }
}