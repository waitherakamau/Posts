package dev.effence.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.effence.mypost.databinding.ActivityCommentsBinding
import dev.effence.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPOstById()
        setupToolbar()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPOstById(){
        val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        val request=apiClient.getpostById(postId)
        request.enqueue(object:Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    binding.tvposttitle.text=post?.title
                    binding.tvpostbody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setupToolbar(){

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

}