package com.example.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.exercise.const.PLAYER_1
import com.example.exercise.const.PLAYER_2
import kotlinx.android.synthetic.main.activity_board.*
import kotlinx.android.synthetic.main.activity_main.*

class BoardActivity : AppCompatActivity() {
    val activityName = "BOARD_ACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$activityName ON_CREATE")
        setContentView(R.layout.activity_board)
        val inIntent = getIntent()
        val player1 = inIntent.getStringExtra(PLAYER_1)
        val player2 = inIntent.getStringExtra(PLAYER_2)
        val showBoard = "$player1 VS. $player2"

        activity_board_view.text = showBoard

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
        println(view.tag)
    }

    fun goToHome(view: View) {
        finish()
//        onBackPressed()
    }
}