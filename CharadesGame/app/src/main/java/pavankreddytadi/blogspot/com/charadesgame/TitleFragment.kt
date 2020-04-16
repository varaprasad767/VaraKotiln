package pavankreddytadi.blogspot.com.charadesgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v  : View = inflater.inflate(R.layout.fragment_title,container,false)

        val btn_play = v.findViewById<Button>(R.id.btn_play)
        btn_play.setOnClickListener {
            v.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }

        return v
    }

}
