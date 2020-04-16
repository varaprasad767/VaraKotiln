package pavankreddytadi.blogspot.com.charadesgame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var score_tv : TextView
    lateinit var word_tv : TextView
    lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_game, container, false)
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        Log.i("GameFragment","GameViewModel is initialized")
        score_tv = v.findViewById(R.id.tv_score)
        word_tv = v.findViewById(R.id.tv_word)
        val gotit = v.findViewById<Button>(R.id.btn_gotit)
        val skip = v.findViewById<Button>(R.id.btn_skip)
        val endgame = v.findViewById<Button>(R.id.btn_endgame)

        if(gameViewModel.words!="")
        {
            word_tv.text = gameViewModel.words
            score_tv.text = gameViewModel.score.toString()
        }
        else{
            gameViewModel.resetWords()
            initViews()
            gameViewModel.resetWords()
        }

        gotit.setOnClickListener {
            gameViewModel.updatePositiveScore()
            score_tv.text = gameViewModel.score.toString()
            initViews()
        }

        skip.setOnClickListener {
            gameViewModel.updateNegativeScore()
            score_tv.text = gameViewModel.score.toString()
            initViews()
        }

        return v
    }

    private fun initViews() {
        gameViewModel.selectWords()
        word_tv.text = gameViewModel.words
    }



}
