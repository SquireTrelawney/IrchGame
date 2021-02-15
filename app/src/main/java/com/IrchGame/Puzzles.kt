package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Puzzles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzles)
    }

    fun open_store_puzzle(view: View){
        val window = Intent(this, Store_Puzzle::class.java)
        startActivity(window)
    }
}