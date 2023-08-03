package com.ruhlanusubov.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruhlanusubov.intent.databinding.ActivityIntroBinding
import com.ruhlanusubov.intent.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}