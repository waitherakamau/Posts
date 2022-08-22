package dev.effence.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.effence.mypost.databinding.RetrofitPostItemBinding


class PostRvAdapter ( var postList: List<Post>)
: RecyclerView.Adapter<RetrofitViewHolder> (){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
                var bindingView = RetrofitPostItemBinding
                        .inflate(LayoutInflater.from( parent.context),parent,false)
                return  RetrofitViewHolder(bindingView)
        }

        override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
                var currentItem = postList.get(position)

                val context=holder.itemView.context
                holder.bindingView.cvretrofit.setOnClickListener(){
                        val intent=Intent(context,CommentsActivity::class.java)
                        intent.putExtra("POST_ID",currentItem.id)
                        context.startActivity(intent)

                }

                with(holder.bindingView){
                        tvuserId.text = currentItem.userId.toString()
                        tvId.text = currentItem.id.toString()
                        tvtitle.text = currentItem.title
                        tvbody.text= currentItem.body

                }
        }

        override fun getItemCount(): Int {
                return postList.size
        }
}

class RetrofitViewHolder(var bindingView: RetrofitPostItemBinding):
        RecyclerView.ViewHolder(bindingView.root)


