package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

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
        scaleAnimate(view, window, true)
    }

    fun open_shadows(view: View) {
        val window = Intent(this, shadows_puzzle::class.java)
        scaleAnimate(view, window, true)
    }

    fun open_store_puzzle(view: View){
        val window = Intent(this, com.IrchGame.StorePuzzle.Store_Main::class.java)
        scaleAnimate(view, window, true)
    }
    fun scaleAnimate(view: View, window: Intent, isFirstAnimation: Boolean){
        var  scaleAnimation : ScaleAnimation;
        if (isFirstAnimation) scaleAnimation = ScaleAnimation(1F,1.1F, 1F,1.1F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F)
        else scaleAnimation = ScaleAnimation(1.1F,1F, 1.1F,1F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F)
        scaleAnimation.duration = 50
        scaleAnimation.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                if(isFirstAnimation)
                    scaleAnimate(view, window, false)
                else startActivity(window)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        view.startAnimation(scaleAnimation)
    }
}