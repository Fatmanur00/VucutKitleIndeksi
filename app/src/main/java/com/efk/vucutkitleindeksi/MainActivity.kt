package com.efk.vucutkitleindeksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var boy: EditText
    private lateinit var kilo: EditText
    private lateinit var hesapla: Button
    private lateinit var sonucText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boy = findViewById(R.id.boy)
        kilo = findViewById(R.id.kilo)
        hesapla = findViewById(R.id.hesapla)
        sonucText = findViewById(R.id.sonucText)

        hesapla.setOnClickListener {
            hesaplaVKI()
        }
    }


    private fun hesaplaVKI() {
        val boyStr = boy.text.toString()
        val kiloStr = kilo.text.toString()

        if (boyStr.isNotEmpty() && kiloStr.isNotEmpty()) {
            val boy = boyStr.toFloat() / 100
            val kilo = kiloStr.toFloat()

            val vki = kilo / (boy * boy)
            val sonuc = String.format("%.2f", vki)

            val durum = when {
                vki < 18.5 -> "İdeal Kilonun Altında"
                vki < 25 -> "İdeal kiloda"
                vki < 30 -> " İdeal kilonun üstünde"
                else -> " İdeal kilonun çok üstünde (obez)"
            }

            sonucText.text = "VKİ: $sonuc\nDurum: $durum"
        } else {
            sonucText.text = "Lütfen boy ve kilo değerlerini girin."
        }
    }
}