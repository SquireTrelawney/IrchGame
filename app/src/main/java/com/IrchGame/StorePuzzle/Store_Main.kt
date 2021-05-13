package com.IrchGame.StorePuzzle

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.IrchGame.R
import kotlinx.android.synthetic.main.activity_store_puzzle.*


@Suppress("DEPRECATION")
class Store_Main : AppCompatActivity() {
    private lateinit var basketImages: Map<Int, List<ImageView>>
    private lateinit var moveImages: Map<Int, ImageView>
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
        moveImages = mapOf(
            R.id.btnCookie_1 to moveImg_cookie,
            R.id.btnCookie_2 to moveImg_cookie_2,
            R.id.btnWaffle_2 to moveImg_waffle,
            R.id.btnKeks to moveImg_keks
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

                    count++
                    var dist = 500F
//                    moveImage(moveImages[btnId]!!, img, 0F, img.x + basket_layout.x - dist, 0F, img.y + basket_layout.y, false)
                    counters[btnId]?.text = count.toString() + "/" + basketImages[btnId]?.size
                    val  moveAnimation = AnimationSet(false);
                    moveAnimation.addAnimation(moveImage(moveImages[btnId]!!, img, 0F, img.x + basket_layout.x - dist, 0F, img.y + basket_layout.y, false))
                    moveAnimation.addAnimation(moveImage(moveImages[btnId]!!, img, 0F,   moveImages[btnId]!!.x + dist, 0F, moveImages[btnId]!!.y, true))
                    moveImages[btnId]!!.startAnimation(moveAnimation)
                    break
                }
                count++
            }
        }
    }
//    , fromXDelta: Float, toXDelta: Float, fromYDelta: Float,toYDelta: Float
    fun  moveImage( moveImg: ImageView, basketImage: ImageView, fromX: Float, toX: Float, fromY: Float, toY: Float,isEndTranslation: Boolean ): TranslateAnimation {
        val animation = TranslateAnimation( fromX,  toX - moveImg.x,  fromY, toY - moveImg.y )
        if (isEndTranslation) {
            animation.duration = 1500
            animation.startOffset = 1000
        }
        else animation.duration = 2000
        animation.setAnimationListener(object: AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
//                if (!isEndTranslation)
                    moveImg.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {

                if (isEndTranslation){

                    if (basketImage != null)
                        basketImage.visibility = View.VISIBLE
                }else{

//                    moveImage(moveImg, basketImage, toX - moveImg.x, toX + 500F, toY - moveImg.y, toY, true)
                }
                moveImg.visibility = View.INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        });
        animation.fillAfter = false
//        moveImg.startAnimation(animation)
        return animation
    }

    private fun checkEndGame() {
    }


}
