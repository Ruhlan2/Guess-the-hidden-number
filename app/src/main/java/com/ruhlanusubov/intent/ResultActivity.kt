package com.ruhlanusubov.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.ruhlanusubov.intent.databinding.ActivityResultBinding
import java.util.zip.Inflater

class ResultActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        result()
    }

    private fun result(){
        val bool=intent.getBooleanExtra("win",false)
        if(bool){
                binding.lottieWin.visibility= View.VISIBLE
                binding.lottieWin.animate().setDuration(3000L).start()
        }else{
            binding.lottieLose.visibility=View.VISIBLE
            binding.lottieLose.animate().setDuration(3000L).start()

        }
        binding.retry.setOnClickListener {
            val intent=Intent(this,IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.exit.setOnClickListener {
            val alertbuilder=AlertDialog.Builder(this)
            alertbuilder.setTitle("Information")
            alertbuilder.setMessage("Are u sure?")
            alertbuilder.setPositiveButton("OK"){dialog,which->
                finish()
            }
            alertbuilder.setNegativeButton("NO"){_,_->
                alertbuilder.setCancelable(false)
            }
            alertbuilder.create().show()
        }
    }

}