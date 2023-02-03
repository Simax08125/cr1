package com.example.cr

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.view.View
import android.widget.TextView

private var counter = 0
    private var prefs:SharedPreferences? = null
    lateinit var txt:TextView

class main1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        txt = findViewById(R.id.textView)
        prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        counter = prefs?.getInt("counter", 0)!!
        txt.text = counter.toString()
    }

    fun plus(view: View){
        counter++
        txt.text = counter.toString()
    }

    fun minus(view: View){
        counter--
        txt.text = counter.toString()
    }
    fun save(view: View){
        savedt(counter)
    }
    private fun savedt(result: Int){
        val editor = prefs?.edit()
        editor?.putInt("counter", result)
        editor?.apply()
    }
}