package com.sg.post10.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sg.post10.NewPost
import com.sg.post10.R

class PostAdapter(private var postList: MutableList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindPost(postList[position])
    }

    override fun getItemCount() = postList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var post: Post
        private var date: TextView
        private var title: TextView
        private var discription: TextView

        init {
            itemView.setOnClickListener(this)
            date = itemView.findViewById(R.id.date_recycler_item)
            title = itemView.findViewById(R.id.title_recycler_item)
            discription = itemView.findViewById(R.id.discription_recycler_item)


        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, NewPost::class.java)
            intent.putExtra("IDofRow", post.id)
            context.startActivity(intent)
        }

        fun bindPost(post: Post) {
            this.post = post
            date.text = post.date
            title.text = post.title
            discription.text=post.description

        }

    }
}