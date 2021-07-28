package com.IrchGame

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_end_puzzle.*

class End_puzzle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_puzzle)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
//        val myClass = Class.forName(intent.getStringExtra("класс")).kotlin
        var countStars = intent.getIntExtra("stars", -1)
        starsAnimation(countStars)
        nextbutton.init(Intent(this, Puzzles::class.java), this)
    }

    fun starsAnimation(countStars: Int){
        var starsImages = arrayOf(image_star1, image_star2, image_star3)
        for (i in 0 until countStars){
            var scaleAnimation = ScaleAnimation(
                0.1f,
                1f,
                0.1f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f)
            scaleAnimation.duration = 500L * (i + 1)
            scaleAnimation.startOffset = 500L * i
            scaleAnimation.setAnimationListener(object: Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    if (i == 0) starsImages[i].setImageResource(R.drawable.end_puzzle_star)
                }
                override fun onAnimationEnd(animation: Animation?) {
                   if (i + 1 < countStars) starsImages[i + 1].setImageResource(R.drawable.end_puzzle_star)
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
            starsImages[i].startAnimation(scaleAnimation)
        }
    }
    override fun onBackPressed(){
        startActivity(Intent(this, Puzzles::class.java))
        finish()
    }
}


