package com.dalemncy.demo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dalemncy.demo.firestore.adapters.PostAdapter
import com.dalemncy.demo.firestore.constants.Constants
import com.dalemncy.demo.firestore.databinding.ActivityListBinding
import com.dalemncy.demo.firestore.models.Post
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signIn()

        binding.add.setOnClickListener {
            startActivity(Intent(this, CreatePostActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getPost()
    }

    private fun signIn() {
        Firebase.auth.signInAnonymously()
    }

    private fun getPost() {
        val activity = this
        Firebase.firestore.collection(Constants.POST)
            .orderBy(Constants.POST_TIMESTAMP)
            .get()
            .addOnSuccessListener { documents ->
                val postList: MutableList<Post> = ArrayList()
                for (document in documents) {
                    val post = Post(
                        id = document.id,
                        description = document.getString(Constants.POST_DESCRIPTION) ?: "",
                    )
                    postList.add(post)
                }
                binding.postList.layoutManager = LinearLayoutManager(activity)
                binding.postList.adapter = PostAdapter(activity, postList)
                binding.progress.visibility = View.GONE
            }
            .addOnFailureListener {
                showError()
            }
    }

    private fun showError() {
        Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
    }
}