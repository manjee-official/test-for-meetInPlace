package com.example.meetinplace.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityMeetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMeetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMeetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}