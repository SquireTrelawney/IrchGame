package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun open_map(view: View) {
        val window = Intent(this, StoryMap::class.java)
        startActivity(window)
    }

    fun open_puzzles(view: View) {
        val window = Intent(this, Puzzles::class.java)
        startActivity(window)
    }
}