package com.ruhlanusubov.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ruhlanusubov.intent.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val handler=Handler()
        binding.lottieNumber.animate().setDuration(3000L).start()
        val runnable=Runnable{
            val intent=Intent(this,IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable,3000L)
    }
}