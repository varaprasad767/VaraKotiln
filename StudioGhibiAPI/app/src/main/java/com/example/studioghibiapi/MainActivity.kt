package com.example.studioghibiapi

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URI
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var result : TextView
    val LINK : String = "https://cat-fact.herokuapp.com/facts"
    lateinit var progressBar : ProgressBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.result)
        val btn = findViewById<Button>(R.id.fetch_btn)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.GONE



        btn.setOnClickListener {
            /*fetchCatFacts(result).execute(LINK)*/
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchCatFacts()
            }
        }

        btn2.setOnClickListener {
            progressBar2.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchRandomJSON()
            }
        }
    }

    private suspend fun fetchRandomJSON() {
        /*Run this code in a background thread - UI Should'nt be accessed*/
        val url = URL(LINK2)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult2(text)
        }
    }

    private fun setValueOnResult2(text: String){
        result2.text = text
        progressBar2.visibility = View.GONE
    }

    suspend fun fetchCatFacts(){
        /*Run this code in a background thread - UI Should'nt be accessed*/
        val url = URL(LINK)
        val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream : InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult(text)
        }
    }

    private fun setValueOnResult(text: String) {
        progressBar.visibility = View.GONE
        result.text = text
    }
    /*class fetchCatFacts(val result : TextView) : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            val LINK = params[0]
            val url = URL(LINK)
            val httpsURLConnection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
            val inputStream : InputStream = httpsURLConnection.inputStream
            *//*val bufferedReader : BufferedReader = BufferedReader(InputStreamReader(inputStream))*//*
            val text = inputStream.bufferedReader().use(BufferedReader::readText)
            return text
        }
        override fun onPostExecute(r: String?) {
            super.onPostExecute(r)
            result.text = r
        }
    }*/
}