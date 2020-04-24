package com.example.myassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    val LINK: String = "https://cat-fact.herokuapp.com/facts"
    lateinit var list: MutableList<MyData>
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.GONE
        // result = findViewById(R.id.result)
        recyclerView = findViewById(R.id.recyclerview)
        list = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            fetchCatFacts()


        }
    }

    suspend fun fetchCatFacts() {
        val url = URL(LINK)
        val httpsURLConnection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream: InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main) {
            setValueOnResult(text)
        }
    }

    private fun setValueOnResult(text: String) {
        progressBar.visibility = View.GONE
        val rootObj = JSONObject(text)
        val results = rootObj.getJSONArray("all")
        for (i in 0..results.length() - 1) {
            val resultsobj: JSONObject = results.getJSONObject(1)
            val name: String = resultsobj.getString("text")
            list.add(MyData(name))

        }
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(this, list)


    }


}