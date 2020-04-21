package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pavankreddytadi.blogspot.com.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    /*//Creating a list Variable
    var list = mutableListOf<String>()*/

    /*//To Retrive Values from the list
    var index = 0*/

    //Creating an Object for MainViewModel
    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.myvar = mainViewModel

        mainViewModel.word.observe(this, Observer {
            binding.worddisplay.text = mainViewModel.word.value
        })

        mainViewModel.word_list.observe(this, Observer {
            binding.listdisplay.text = mainViewModel.word_list.value
        })

        /*//Initialize the List
        initList()*/

        // Listen to Update btn Click
        /*binding.updateBtn.setOnClickListener {
            mainViewModel.updateList()
        }
        //next Word
        binding.next.setOnClickListener {
            mainViewModel.nextWord()
        }
        //prev Word
        binding.prev.setOnClickListener {
            mainViewModel.prevWord()
        }*/
    }

    /*private fun initList() {
        list = mutableListOf("Apple", "Banana")
        displayWord(index)
        displayValues()
    }*/

    /* private fun updateList() {
         for (i in 0..9) {
             list.add("Grapes ${i + 1}")
         }
         displayValues()
     }*/

    /*private fun displayValues() {
        binding.listdisplay.text = ""
        for (i in list) {
            binding.listdisplay.append(i + " ")
        }
    }*/

    /*private fun displayWord(i:Int){
        binding.worddisplay.text = list.get(i)
    }*/
}
