package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding
import java.lang.reflect.Array.getChar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnConfirm.setOnClickListener { onCheck() }
    }

    private fun onCheck() {
        val truthTable: ArrayList<String> = arrayListOf("T", "F", "F", "F")
        val truthTableAnswers: ArrayList<String> = ArrayList()
        var wrongAnswer: Int = 0

        truthTableAnswers.add(binding.txtRow1.text.toString())
        truthTableAnswers.add(binding.txtRow2.text.toString())
        truthTableAnswers.add(binding.txtRow3.text.toString())
        truthTableAnswers.add(binding.txtRow4.text.toString())

        for (i in 0 until 4) {
            if (truthTable[i].toLowerCase() != truthTableAnswers[i].toLowerCase()) {
                wrongAnswer++
            }
        }
        showMessage(wrongAnswer)
    }

    private fun showMessage(number: Int) {
        println(number)
        Toast.makeText(this, getString(R.string.wrong_answers, number), Toast.LENGTH_SHORT).show()
    }

}