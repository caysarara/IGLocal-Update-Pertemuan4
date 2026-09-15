package com.example.iglocal_caysa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iglocal_caysa.databinding.ActivityPhotoBinding

class PhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME) ?: getString(R.string.username)
        binding.tvUsernamePhoto.text = username

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}