package com.example.iglocal_caysa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iglocal_caysa.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentName = intent.getStringExtra(EXTRA_NAME) ?: ""
        val currentBio = intent.getStringExtra(EXTRA_BIO) ?: ""

        with(binding) {
            etName.setText(currentName)
            etBio.setText(currentBio)

            btnSave.setOnClickListener {
                val resultIntent = Intent().apply {
                    putExtra(EXTRA_NAME, etName.text.toString())
                    putExtra(EXTRA_BIO, etBio.text.toString())
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
