package com.sg.post10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.sg.post10.data.Post
import com.sg.post10.data.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var postList:ArrayList<Post>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postList= ArrayList()
        imageView.load(R.drawable.post)
        preAction()

    }

    override fun onStart() {
        super.onStart()
     //postList.clear()
        displayDateInfo()
    }

    private fun displayDateInfo() {
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=PostAdapter(postList)

    }

    private fun preAction() {

        var currentDay=SimpleDateFormat("EEE, d MMM yyyy").format(Date())

        postList.add(Post(1,currentDay,"First Post","It's first"))
        postList.add(Post(2,currentDay,"Secont Post","It's Second"))
    }
}