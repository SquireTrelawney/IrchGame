package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Puzzles : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzles)
        (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION).also { window.decorView.systemUiVisibility = it }
//        val window = Intent(this, com.IrchGame.StorePuzzle.Store_Main::class.java)
//        startActivity(window)
    }

    fun open_separation(view: View) {
        val window = Intent(this, Separation_Puzzle::class.java)
        startActivity(window)
    }

    fun open_shadows(view: View) {
        val window = Intent(this, shadows_puzzle::class.java)
        startActivity(window)
    }

    fun open_store_puzzle(view: View){
        val window = Intent(this, com.IrchGame.StorePuzzle.Store_Main::class.java)
        startActivity(window)
    }

}