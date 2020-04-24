package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import pavankreddytadi.blogspot.com.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        databinding.setBtn.setOnClickListener { setName() }
    }

    private fun setName() {
        val n = databinding.name.text.toString()
        /*databinding.displayName.text = n*/
        val d = Name(n)
        databinding.n = d
        databinding.name.text.clear()
    }
}