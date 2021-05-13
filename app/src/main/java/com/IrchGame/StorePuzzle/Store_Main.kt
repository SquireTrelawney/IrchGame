package com.IrchGame.StorePuzzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.IrchGame.R
import kotlinx.android.synthetic.main.activity_store_puzzle.*

class Store_Main() : AppCompatActivity() {
    private lateinit var basketImages: Map<Int, List<ImageView>>;
    private lateinit var counters: Map<Int, TextView> ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_puzzle)
        counters = mapOf(
                R.id.btnCookie_1 to  text_cookie_1,
                R.id.btnCookie_2 to text_cookie_2,
                R.id.btnWaffle_2 to text_waffle_2,
                R.id.btnKeks to text_keks
        )
        basketImages = mapOf(
                R.id.btnCookie_1 to  listOf(image_1_cookie_1, image_2_cookie_1, image_3_cookie_1, image_4_cookie_1, image_5_cookie_1),
                R.id.btnCookie_2 to listOf(image_1_cookie_2, image_2_cookie_2, image_3_cookie_2),
                R.id.btnWaffle_2 to listOf(image_1_waffle_2, image_2_waffle_2, image_3_waffle_2, image_4_waffle_2),
                R.id.btnKeks to listOf(image_1_keks_1, image_2_keks_1, image_3_keks_1, image_4_keks_1)
        )
//        countOfDonutsText.setText(countOfDonuts.toString())
        for((id, listsValue) in basketImages){
            counters[id]?.setText("0/" + listsValue.size)
            for(image in listsValue){
                image.visibility = View.INVISIBLE;
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
                    count++;
                    counters[btnId]?.setText(count.toString() + "/" + basketImages[btnId]?.size)
                    break;
                }
                count++;
            }
        }
    }

    private fun checkEndGame() {
    }
}