package com.tahayasindogukan.guessinggame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tahayasindogukan.guessinggame.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {

    private var rasgeleSayi = 0

    private var sayac = 5



    private lateinit var binding: ActivityTahminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rasgeleSayi = Random.nextInt(101)
        Log.e("Rasgele Sayı",rasgeleSayi.toString())



        binding.buttonTahmin.setOnClickListener {

            sayac = sayac - 1
            val tahmin = binding.editTextGirdi.text.toString().toInt()

            if (tahmin == rasgeleSayi){

                val intent = Intent(this@TahminActivity, SonucActivity::class.java)
                intent.putExtra("sonuc",true)

                finish() //bu ekranı backstackden siler sayfa geçişi yapınca
                startActivity(intent)

                return@setOnClickListener //bu if çalışırsa alttaki kodlar çalışmaz.
            // Son hakkımızda bilirsek hak 1 azalır 0 olur ve yine kaybettin der bunu engelliyor bu

            }

            if(tahmin>rasgeleSayi){
                binding.textViewYardM.text="Azalt"
                binding.textViewKalanHak.text="Kalan hak: $sayac"
            }

            if (tahmin<rasgeleSayi){
                binding.textViewYardM.text="Arttır"
                binding.textViewKalanHak.text="Kalan hak: $sayac"
            }

            if (sayac==0){

                val intent = Intent(this@TahminActivity, SonucActivity::class.java)
                intent.putExtra("sonuc",false)

                finish() //bu ekranı backstackden siler sayfa geçişi yapınca
                startActivity(intent)
            }

            binding.editTextGirdi.setText("")

        }

















    }

}