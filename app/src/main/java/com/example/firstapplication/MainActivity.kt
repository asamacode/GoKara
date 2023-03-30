package com.example.firstapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterSentence: AdapterSentence
    private val handler = Handler(Looper.getMainLooper())
    private var content1 = "HELLO WORLD HIHI1"
    private var content2 = "HELLO HIHIH WORD2"
    private var content3 = "HELLO WORLD HIHI"
    private var content4 = "HELLO HIHIH WORD"
    private var content5 = "HELLO WORLD HIHI3"
    private var content6 = "HELLO HIHIH WORD4"
    private var content7 = "HELLO WORLD HIHI5"
    private var content8 = "HELLO WORLD HIHI6"
    private var content9 = "HELLO WORLD HIHI7"
    private var content10 = "HELLO WORLD HIHI8"
    private var content11 = "HELLO WORLD HIHI9"
    private var content12 = "HELLO WORLD HIHI10"
    private var content13 = "HELLO WORLD HIHI11"
    private var content14 = "HELLO WORLD HIHI12"

    private var songs = listOf<SentenceData>(
        SentenceData(content1, false),
        SentenceData(content2, false),
        SentenceData(content3, true),
        SentenceData(content4, false),
        SentenceData(content5, false),
        SentenceData(content6, false),
        SentenceData(content7, false),
        SentenceData(content8, false),
        SentenceData(content9, false),
        SentenceData(content10, false),
        SentenceData(content11, false),
        SentenceData(content12, false),
        SentenceData(content13, false),
        SentenceData(content14, false),
        )

    private var songsChange = listOf<SentenceData>(
        SentenceData(content1, false),
        SentenceData(content2, false),
        SentenceData(content3, false),
        SentenceData(content4, true),
        SentenceData(content5, false),
        SentenceData(content6, false),
        SentenceData(content7, false),
        SentenceData(content8, false),
        SentenceData(content9, false),
        SentenceData(content10, false),
        SentenceData(content11, false),
        SentenceData(content12, false),
        SentenceData(content13, false),
        SentenceData(content14, false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterSentence = AdapterSentence(songs)
        binding.recyclerSong.apply {
            adapter = adapterSentence
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        handler.postDelayed({
            adapterSentence = AdapterSentence(songsChange)
            binding.recyclerSong.adapter = adapterSentence
            handler.postDelayed({
                binding.recyclerSong.smoothScrollToPosition(2)
            }, 500)
        }, 4000)
    }
}
