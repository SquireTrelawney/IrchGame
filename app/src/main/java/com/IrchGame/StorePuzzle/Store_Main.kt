package com.IrchGame.StorePuzzle

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.IrchGame.R
import kotlinx.android.synthetic.main.activity_store_puzzle.*


@Suppress("DEPRECATION")
class Store_Main : AppCompatActivity() {
    private lateinit var basketImages: Map<Int, List<ImageView>>
    private lateinit var counters: Map<Int, TextView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_store_puzzle)
        (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION).also { window.decorView.systemUiVisibility = it }
        counters = mapOf(
            R.id.btnCookie_1 to text_cookie_1,
            R.id.btnCookie_2 to text_cookie_2,
            R.id.btnWaffle_2 to text_waffle_2,
            R.id.btnKeks to text_keks
        )
        basketImages = mapOf(
            R.id.btnCookie_1 to listOf(
                image_1_cookie_1,
                image_2_cookie_1,
                image_3_cookie_1,
                image_4_cookie_1,
                image_5_cookie_1
            ),
            R.id.btnCookie_2 to listOf(image_1_cookie_2, image_2_cookie_2, image_3_cookie_2),
            R.id.btnWaffle_2 to listOf(
                image_1_waffle_2,
                image_2_waffle_2,
                image_3_waffle_2,
                image_4_waffle_2
            ),
            R.id.btnKeks to listOf(
                image_1_keks_1,
                image_2_keks_1,
                image_3_keks_1,
                image_4_keks_1
            )
        )
//        countOfDonutsText.setText(countOfDonuts.toString())
        for((id, listsValue) in basketImages){
            counters[id]?.text = "0/" + listsValue.size
            for(image in listsValue){
                image.visibility = View.INVISIBLE
            }
        }

    }

    fun onClick(view: View){
        var btnId = view.id
        if(btnId in basketImages.keys) {
            var count = 0
            for (img in basketImages[btnId]!!){
                if((img.visibility == View.INVISIBLE)){
                    img.visibility = View.VISIBLE
                    count++
                    var pic = img.drawable
//                    moveImage(pic)
                    counters[btnId]?.text = count.toString() + "/" + basketImages[btnId]?.size
                    break
                }
                count++
            }
        }
    }

//    fun moveImage(pic: Drawable){
//        var moveImg = imageForMove
//        moveImg.setImageDrawable(pic)
//        val animation = TranslateAnimation(0F, 500F, 0F, 500F)
//        animation.duration = 3000
//        animation.setAnimationListener(object: AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//
//            }
//
//        });
//        animation.fillAfter = true
//        imageForMove.startAnimation(animation)
//
//
//    }

    private fun checkEndGame() {
    }


}
