package com.IrchGame.StorePuzzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.IrchGame.R
import kotlinx.android.synthetic.main.activity_store_puzzle.*

class Store_Main() : AppCompatActivity() {
    private lateinit var basketImages: Map<String, List<ImageView>>;
    private var countOfDonuts = 5;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_puzzle)
        basketImages = mapOf(
                "cookie_1" to  listOf(image_1_cookie_1, image_2_cookie_1, image_3_cookie_1, image_4_cookie_1, image_5_cookie_1),
                "cookie_2" to listOf(image_1_cookie_2, image_3_cookie_2, image_2_cookie_2),
                "waffle_1" to listOf(image_1_waffle_1, image_2_waffle_1, image_3_waffle_1, image_4_waffle_1),
                "keks" to listOf(image_1_keks_1, image_2_keks_1, image_3_keks_1, image_4_keks_1)
        )
//        countOfDonutsText.setText(countOfDonuts.toString())
        for(listsValue in basketImages.values){
            for(image in listsValue){
                image.visibility = View.INVISIBLE;
            }
        }

    }

    fun onCookie_1(view: View){
        basketImages["cookie_1"]?.get(0)?.visibility =  View.VISIBLE;
    }

    private fun checkEndGame() {
        if(countOfDonuts == 0){
//            congratsText.visibility = View.VISIBLE
        }
    }
}