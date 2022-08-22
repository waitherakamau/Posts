package dev.effence.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import javax.security.auth.callback.Callback

//
//class ApiInterface : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_api_interface)
//    }
//}
interface ApiInterface{
    @GET("/posts")
    fun getPost(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getpostById(@Path("postId")postId:Int):Call<Post>
}