package com.example.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.exercise.const.PLAYER_1
import com.example.exercise.const.PLAYER_2
import kotlinx.android.synthetic.main.activity_board.*
import kotlinx.android.synthetic.main.activity_main.*

class BoardActivity : AppCompatActivity() {
    val activityName = "BOARD_ACTIVITY"
    var ActivePlayer = true
    var tacToePlayer1= arrayOf<Int>()
    var tacToePlayer2= arrayOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$activityName ON_CREATE")
        setContentView(R.layout.activity_board)
        val inIntent = getIntent()
        val player1 = inIntent.getStringExtra(PLAYER_1)
        val player2 = inIntent.getStringExtra(PLAYER_2)
        val showBoard = "$player1 VS. $player2"
//        activity_board_view.text = showBoard
    activity_board_view.text = "$player1 turn"
//        var ActivePlayer = player1

    }
    override fun onStart() {
        super.onStart()
        println("$activityName ON_START")

    }

    override fun onResume() {
        super.onResume()
        println("$activityName ON_RESUME")
    }

    override fun onPause() {
        super.onPause()
        println("$activityName ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        println("$activityName ON_STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$activityName ON_DESTROY")
    }



    fun flip(view: View) {
        view as Button
//        val index = view.tag.toString().toInt()
//        println("ini index $index")
        clickToPlay(view)
    }
    fun clickToPlay(view: Button){
        val inIntent = getIntent()
        val player1 = inIntent.getStringExtra(PLAYER_1)
        val player2 = inIntent.getStringExtra(PLAYER_2)
        if (ActivePlayer){
            view.text = "X"
            activity_board_view.text = "$player2 turn"
            ActivePlayer=false
        } else{
            view.text = "O"
            activity_board_view.text ="$player1 turn"
            ActivePlayer=true
        }
    view.isEnabled=false
    }

    fun goToHome(view: View) {
        finish()
//        onBackPressed()
    }
}