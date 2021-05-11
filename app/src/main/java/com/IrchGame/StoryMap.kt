package com.IrchGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StoryMap : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_map)
        (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION).also { window.decorView.systemUiVisibility = it }
    }

}