package com.dalemncy.demo.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.dalemncy.demo.firestore.constants.Constants
import com.dalemncy.demo.firestore.databinding.ActivityPostBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        getPost()
    }

    private fun getPost() {
        val id = intent.getStringExtra(Constants.PARAM_ID) ?: return
        Firebase.firestore
            .collection(Constants.POST)
            .document(id)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    binding.description.text = document.getString(Constants.POST_DESCRIPTION) ?: ""
                    binding.progress.visibility = View.GONE
                } else {
                    showError()
                }
            }
    }

    private fun showError() {
        Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
    }
}