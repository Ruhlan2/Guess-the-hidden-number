package com.ruhlanusubov.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.ruhlanusubov.intent.databinding.ActivityAnimationBinding
import com.ruhlanusubov.intent.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        game()
    }


    private fun game(){
       binding.btn.setOnClickListener {

           val intent=Intent(this,GameActivity::class.java)
           intent.putExtra("Easy_clicked",true)
           startActivity(intent)
           finish()
       }
        binding.hardBtn.setOnClickListener {
            val intent=Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
        binding.questionmark.setOnClickListener {

            val intent=Intent(this,QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}