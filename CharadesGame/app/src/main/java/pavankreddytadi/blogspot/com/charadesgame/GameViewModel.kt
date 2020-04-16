package pavankreddytadi.blogspot.com.charadesgame

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var score = 0
    var words = ""
    var wordslist : MutableList<String> = mutableListOf()
    fun resetWords(){
        wordslist = mutableListOf("Duck","Dog","fox","chocolate","table","chair","Mouse","Cat","Elephant","Coat")
        wordslist.shuffle()
    }
    fun selectWords(){
        if(wordslist.isEmpty()){
            words = "ALL WORDS ARE COMPLETE"
        }
        else{
            words = wordslist.removeAt(0)
        }
    }
    fun updatePositiveScore(){
        if(score<10)
        {
            score++
        }
    }
    fun updateNegativeScore(){
        if(score>-10){
            score--
        }
    }

    init {
        Log.i("GameViewModel","ViewModel is Created!")
    }

    // The ViewModel is Destroyed when the associated fragment is detached or when tge activity
    // is destroyed. Just before the viewmodel is destroyed it will encounter a
    // method called oncleared()

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","ViewModel is destroyed")
    }
}