package com.example.pertemuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("EXTRA_NAME")

        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val resultIntent = Intent()

                resultIntent.putExtra("EXTRA_NAME", name)
                resultIntent.putExtra("EXTRA_ADDRESS", editAddress.text.toString())

                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }

    }
}