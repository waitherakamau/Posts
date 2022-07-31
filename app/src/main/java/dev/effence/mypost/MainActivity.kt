package dev.effence.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.effence.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPost()
    }
    fun fetchPost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPost()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   var posts = response.body()
                   Toast.makeText(baseContext, "${posts!!.size} posts", Toast.
                   LENGTH_LONG).show()
                   var adapter=PostRvAdapter(baseContext,posts)
                   Log.d("Tag",fetchPost().toString())
                   binding.rvretrofit.adapter=adapter
                   binding.rvretrofit.layoutManager=LinearLayoutManager(baseContext)

               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }


        })
    }
}