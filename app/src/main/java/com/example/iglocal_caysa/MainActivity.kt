package com.example.iglocal_caysa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iglocal_caysa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var editProfileLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editProfileLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val newName = data?.getStringExtra(EditProfileActivity.EXTRA_NAME)
                val newBio = data?.getStringExtra(EditProfileActivity.EXTRA_BIO)
                if (!newName.isNullOrEmpty()) binding.tvUsername.text = newName
                if (!newBio.isNullOrEmpty()) binding.tvBioContent.text = newBio
            }

        }

        with(binding) {
            btnEditProfile.setOnClickListener {
                val intentToEditProfile = Intent(this@MainActivity, EditProfileActivity::class.java)
                    .apply {
                        putExtra(EditProfileActivity.EXTRA_NAME, tvUsername.text.toString())
                        putExtra(EditProfileActivity.EXTRA_BIO, tvBioContent.text.toString())
                    }
                editProfileLauncher.launch(intentToEditProfile)
            }

            ivProfile.setOnClickListener {
                val intentToPhoto = Intent(this@MainActivity, PhotoActivity::class.java)
                    .apply { putExtra(PhotoActivity.EXTRA_USERNAME, tvUsername.text.toString()) }
                startActivity(intentToPhoto)
            }
        }

    }
}