package com.IrchGame

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_separation__puzzle.*
import kotlin.random.Random


class Separation_Puzzle : AppCompatActivity() {

    class img(side: String, url: Int){
        var switch = side
        var img = url
        fun set(parent: img, side: String, url: Int){
            parent.switch = side
            parent.img = url
        }
    }

    var mid_image = img("left", R.drawable.slon_8)
    var score = 0
    var timer = object: CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val cdt = millisUntilFinished.toInt() / 1000
            val result = Math.round(cdt.toDouble())
            TextView.text = result.toString()
        }
        override fun onFinish() {
            TextView.text = "GAME OVER"
            game_over()
        }
    }

    fun restart_timer(score: Long) {
        println("Cчёт " + score)
        if (score <= 17.toLong()){
            timer = object : CountDownTimer(20000 - (score*250), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val cdt = millisUntilFinished.toInt() / 1000
                    val result = Math.round(cdt.toDouble())
                    TextView.text = result.toString()
                }

                override fun onFinish() {
                    TextView.text = "GAME OVER"
                    game_over()
                }
            }
        }
        else{
            timer = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val cdt = millisUntilFinished.toInt() / 1000
                    val result = Math.round(cdt.toDouble())
                    TextView.text = result.toString()
                }

                override fun onFinish() {
                    TextView.text = "GAME OVER"
                    game_over()
                }
            }
        }
        timer.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_separation__puzzle)
        timer.start()
        imageView6.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ind_8))
        imageView7.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.indus_8))
        TextScore2.text = score.toString()
        update_img(imageView5, mid_image)
    }

    fun update_img(view: View, mid_image: img){
        val random_num = Random.nextInt(from = 0, until = 2)
        println(random_num)
        if (random_num == 0){
            mid_image.set(mid_image, "left", R.drawable.ind_8)
        }
        else{
            mid_image.set(mid_image, "right", R.drawable.indus_8)
        }
        imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mid_image.img))
    }

    fun switch_left(view: View){
        if(mid_image.switch == "left"){
            update_img(view, mid_image)
            timer.cancel()
            score += 1
            TextScore2.text = score.toString()
            restart_timer(score.toLong())
        }
        else{
            timer.cancel()
            TextView.text = "GAME OVER"
            game_over()
        }
    }

    fun switch_right(view: View){
        if(mid_image.switch == "right"){
            update_img(view, mid_image)
            timer.cancel()
            score += 1
            TextScore2.text = score.toString()
            restart_timer(score.toLong())
        }
        else{
            timer.cancel()
            TextView.text = "GAME OVER"
            game_over()
        }
    }

    fun game_over(){
        button_left.setVisibility(View.GONE)
        button_right.setVisibility(View.GONE)
        TextScore2.setVisibility(View.GONE)
        TextScore.text = "Ваш счёт: " + score.toString()
        TextScore.setVisibility(View.VISIBLE)
    }
}