package com.example.dsccekilisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.dsccekilisuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var participantList = mutableListOf<Participant>()
    var winnerParticipant = Participant("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollTheWinnerButton.setOnClickListener{ rollTheWinner() }
        binding.addParticipantButton.setOnClickListener{ addParticipantToList() }
    }

    fun addParticipantToList() {

        var fullNameString = binding.fullNameEditText.text.toString()
        var dscNameString = binding.DSCNameEditText.text.toString()

        if (TextUtils.isEmpty(fullNameString) || TextUtils.isEmpty(dscNameString)) {
            binding.infoText.text = "Enter more information"
        }
        else {
            val participant = Participant(fullNameString,dscNameString)
            participantList.add(participant)
            binding.infoText.text = "${participant.fullName} added to list."
        }
        binding.fullNameEditText.text.clear()
        binding.DSCNameEditText.text.clear()

    }

    fun rollTheWinner() {
        if (participantList.count() == 0) {
            binding.infoText.text = "Add more participants before rolling."
        }
        else {
            winnerParticipant = participantList.random()
            binding.winnerFullNameTextView.text = winnerParticipant.fullName
            binding.winnerDSCNameTextView.text = winnerParticipant.dscName
        }
    }

}

class Participant(val fullName : String, val dscName : String) {  }

