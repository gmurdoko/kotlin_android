package com.example.exercise

import android.content.Intent
import android.media.AsyncPlayer
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
    var tacToePlayer1= mutableListOf<Int>()
    var tacToePlayer2= mutableListOf<Int>()
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
            tacToePlayer1.add(view.tag.toString().toInt())
            checkWinner(tacToePlayer1, player1)
        } else{
            view.text = "O"
            activity_board_view.text ="$player1 turn"
            ActivePlayer=true
            tacToePlayer2.add(view.tag.toString().toInt())
            checkWinner(tacToePlayer2,player2)
        }
    view.isEnabled=false


    }
    fun checkWinner(Player: MutableList<Int>,player: String){
        if ((Player.contains(0)&&Player.contains(1)&&Player.contains(2))||(Player.contains(0)&&Player.contains(3)&&Player.contains(6))||(Player.contains(0)&&Player.contains(4)&&Player.contains(8))){
            activity_board_view.text ="$player winner"
        } else if ((Player.contains(1)&&Player.contains(4)&&Player.contains(7))||(Player.contains(2)&&Player.contains(5)&&Player.contains(8))){
            activity_board_view.text ="$player winner"
        } else if ((Player.contains(3)&&Player.contains(4)&&Player.contains(5))||(Player.contains(6)&&Player.contains(7)&&Player.contains(8))){
            activity_board_view.text ="$player winner"
        } else if (Player.contains(2)&&Player.contains(4)&&Player.contains(6)){
            activity_board_view.text ="$player winner"
        }
    }

    fun goToHome(view: View) {
        finish()
//        onBackPressed()
    }
}