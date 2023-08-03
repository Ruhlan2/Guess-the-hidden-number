package com.ruhlanusubov.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.ruhlanusubov.intent.databinding.ActivityGameBinding
import java.util.zip.Inflater
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGameBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        start()
    }

    private fun start(){
        val easy_btn=intent.getBooleanExtra("Easy_clicked",false)
        val hard_btn=intent.getBooleanExtra("Hard_clicked",false)
        val alert= AlertDialog.Builder(this)
        if(easy_btn) {
            binding.guessedit.visibility=View.VISIBLE
            alert.setTitle("Attention!!!")
            alert.setMessage("In easy mode you guess the number betweeen 1-10")
            alert.setPositiveButton("OK") { dialog, which ->
               // Toast.makeText(this, "Enter number between 1-10", Toast.LENGTH_SHORT).show()

            }
            alert.setNegativeButton("Return") { dialog, which ->
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }
            alert.create().show()
            algorithm1(Random.nextInt(10))
        }else {
            binding.digit.visibility=View.VISIBLE
            alert.setTitle("Attention!!!")
            alert.setMessage("In hard mode you guess the number betweeen 1-100")
            alert.setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "Enter number between 1-100", Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("Return") { dialog, which ->
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }
            alert.create().show()

            algorithm2(Random.nextInt(100))

        }

        binding.leftBtn.setOnClickListener {
            alert.setTitle("Attention!!!")
            alert.setMessage("Are u sure?")
            alert.setPositiveButton("Yes"){dialog,which->
                finish()
            }
            alert.setNegativeButton("No"){dialog,which->
                alert.setCancelable(false)
            }
            alert.create().show()
        }

    }
    private fun algorithm1(random:Int){
        var chance=5
        binding.btn.setOnClickListener {
            val entered_num=binding.guessedit.text.toString()
            val enterednum_int=entered_num.toInt()
            if(enterednum_int==random){
                val intent=Intent(this,ResultActivity::class.java)
                intent.putExtra("win",true)
                startActivity(intent)
                finish()
            }else if(enterednum_int>random){
                Toast.makeText(this,"Higher",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Lower" ,Toast.LENGTH_SHORT).show()
            }
            if(chance==0){
                val intent=Intent(this,ResultActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                chance--
                binding.chance.text="Chance: $chance"
            }

        }
    }
    private fun algorithm2(random:Int){
        var chance=5
        binding.btn.setOnClickListener {
            val entered_num=binding.digit.text.toString()
            val enterednum_int=entered_num.toInt()
            if(enterednum_int==random){
                val intent=Intent(this,ResultActivity::class.java)
                intent.putExtra("win",true)
                startActivity(intent)
                finish()
            }else if(enterednum_int>random){
                Toast.makeText(this,"Higher",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Lower" ,Toast.LENGTH_SHORT).show()
            }
            if(chance==0){
                val intent=Intent(this,ResultActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                chance--
                binding.chance.text="Chance: $chance"
            }

        }
    }
}