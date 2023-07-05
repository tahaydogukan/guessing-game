package com.tahayasindogukan.guessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tahayasindogukan.guessinggame.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sonuc = intent.getBooleanExtra("sonuc",false)


        if (sonuc){
            binding.textViewSonuc.text="KAZANDINIZ !"
            binding.imageViewSonuc.setImageResource(R.drawable.mutlu_resim)
        }
        else{
            binding.textViewSonuc.text="KAYBETTİNİZ !"
            binding.imageViewSonuc.setImageResource(R.drawable.uzgun_resim)

        }


        binding.buttonTekrar.setOnClickListener {
            finish() //bu ekranı backstackden siler sayfa geçişi yapınca
            startActivity(Intent(this@SonucActivity, MainActivity::class.java))





        }
    }
}