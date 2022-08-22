package dev.effence.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RemoteViews
import androidx.recyclerview.widget.RecyclerView
import dev.effence.mypost.databinding.RetrofitCommentItemBinding


class CommentsAdapter( var CommentsList: List<Comment>)
    : RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding=RetrofitCommentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentcomment=CommentsList.get(position)
        with(holder.binding){
            tvpostid.text=currentcomment.postId.toString()
            tvCommentsid.text=currentcomment.postId.toString()
            tvemail.text=currentcomment.email.toString()
            tvname.text=currentcomment.name.toString()
            tvcommentsbody.text=currentcomment.body.toString()
        }
    }

    override fun getItemCount(): Int {
        return CommentsList.size
    }


}
class CommentsViewHolder(var binding: RetrofitCommentItemBinding):RecyclerView.ViewHolder(binding.root)