package com.example.firstapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapplication.databinding.ActivityMain1Binding
import com.example.firstapplication.databinding.ActivityMainBinding

class MainActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding
    private val handler = Handler(Looper.getMainLooper())
    private var content = "HELLO WORLD HIHI"
    private var arrContent = content.split(" ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnLogin.setOnClickListener {
//            Intent(this, LoginActivity::class.java).also {
//                startActivity(it)
//            }
//        }

        binding.txtLoading.text = content

        handler.postDelayed({
            for ((index, element) in arrContent.withIndex()) {
                handler.postDelayed({
                    highLightTextView(binding.txtLoading, element, content)
                }, (1000 + (index * 1000)).toLong())
            }
        }, 1000)
    }


    fun highLightTextView(view: TextView, word: String, sentence: String) {
        val spannableString: Spannable = SpannableString(
            binding.txtLoading.text
        )

        val pos = sentence.indexOf(word)

        spannableString.setSpan(
            ForegroundColorSpan(
                Color.YELLOW
            ), pos, pos + word.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        view.text = spannableString
    }
}
