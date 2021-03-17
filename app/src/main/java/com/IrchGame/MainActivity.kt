package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val numbers: IntArray = intArrayOf(R.drawable.ind, R.drawable.indus, R.drawable.slon, R.drawable.kobra, R.drawable.lotos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testImage.setImageResource(R.drawable.b1_8)
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