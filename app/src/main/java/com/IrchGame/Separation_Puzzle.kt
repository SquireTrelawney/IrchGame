package com.IrchGame

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_separation__puzzle.*
import kotlinx.android.synthetic.main.activity_shadows_puzzle.*
import java.lang.reflect.Array
import java.util.*
import kotlin.math.abs
import kotlin.random.Random




class Separation_Puzzle : AppCompatActivity(), GestureDetector.OnGestureListener {

    var game = true

    lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    var obj1: img = img("l", R.drawable.slon_8)
    var obj2: img = img("l", R.drawable.zmeya_8)
    var obj3: img = img("l", R.drawable.znak)
    var obj4: img = img("r", R.drawable.indus)
    var obj5: img = img("r", R.drawable.ind)
    var obj6: img = img("r", R.drawable.og)
    var obj7: img = img("n", R.drawable.tuk)
    var mas = arrayOf(obj1, obj2, obj3, obj4, obj5, obj6)

    var mid_image = img("left", R.drawable.slon_8)
    var score = 1

    companion object{
        const val MIN_DISTANCE = 150
    }

    class img(side: String, url: Int){
        var switch = side
        var img = url
        fun set(parent: img, side: String, url: Int){
            parent.switch = side
            parent.img = url
        }
    }

    fun fill(obj1: img, obj2: img, obj3: img, obj4: img, obj5: img, obj6: img): kotlin.Array<img> {
        val mas_supp = arrayOf(0,0,0,0,0,0)
        val mas_out = arrayOf(obj1, obj2, obj3, obj4, obj5, obj6)

        for (i in 0..5){
            var random_num = Random.nextInt(from = 1, until = 7)
            while (random_num in mas_supp){
                random_num = Random.nextInt(from = 1, until = 7)
            }
            mas_supp[i] = random_num
            if (random_num == 1){
                mas_out[i] = obj1
            }
            if (random_num == 2){
                mas_out[i] = obj2
            }
            if (random_num == 3){
                mas_out[i] = obj3
            }
            if (random_num == 4){
                mas_out[i] = obj4
            }
            if (random_num == 5){
                mas_out[i] = obj5
            }
            if (random_num == 6){
                mas_out[i] = obj6
            }
        }
        return mas_out
    }

//    var timer = object: CountDownTimer(20000, 1000) {
//        override fun onTick(millisUntilFinished: Long) {
//            val cdt = millisUntilFinished.toInt() / 1000
//            val result = Math.round(cdt.toDouble())
//            TextView4.text = result.toString()
//        }
//        override fun onFinish() {
//            TextView.text = "GAME OVER"
//            game_over()
//        }
//    }

//    fun restart_timer(score: Long) {
//        println("Cчёт " + score)
//        if (score <= 17.toLong()){
//            timer = object : CountDownTimer(20000 - (score*250), 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    val cdt = millisUntilFinished.toInt() / 1000
//                    val result = Math.round(cdt.toDouble())
//                    TextView.text = result.toString()
//                }
//
//                override fun onFinish() {
//                    TextView.text = "GAME OVER"
//                    game_over()
//                }
//            }
//        }
//        else{
//            timer = object : CountDownTimer(2000, 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    val cdt = millisUntilFinished.toInt() / 1000
//                    val result = Math.round(cdt.toDouble())
//                    TextView.text = result.toString()
//                }
//
//                override fun onFinish() {
//                    TextView.text = "GAME OVER"
//                    game_over()
//                }
//            }
//        }
//        timer.start()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_separation__puzzle)
//        timer.start()
        imageView6.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ind_8))
        imageView7.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.indus_8))
//        TextScore2.text = score.toString()
        update_img(imageView5, mid_image)

        mas = fill(obj1, obj2, obj3, obj4, obj5, obj6)

        imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mas[score].img))

        gestureDetector = GestureDetector(this, this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        gestureDetector.onTouchEvent(event)

        when(event?.action){
            0->{
                x1 = event.x
                y1 = event.y
            }
            1 -> {
                x2 = event.x
                y2 = event.y

                val valueX: Float = x2 - x1
                val valueY: Float = y2 - y1

                if ((abs(valueX) > MIN_DISTANCE) and (game == true)) {
                    if (x2 > x1) {
                        Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
                        println("Right")
                        switch_right()
                    } else {
                        Toast.makeText(this, "Left swipe", Toast.LENGTH_SHORT).show()
                        println("Left")
                        switch_left()
                    }
                } else if ((abs(valueX) > MIN_DISTANCE) and (game == true)) {
                    if (y2 > y1) {
                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Top swipe", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        return false
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

    fun switch_left(){
        println("score = " + score)
        if (score < 6){
            println(mas[score].switch)
            if(mas[score].switch == "l"){
                score += 1
                imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mas[score].img))
                if (mas[score-1].img == R.drawable.slon_8){
                    imageView14.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.zmeya_8){
                    imageView15.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.znak){
                    imageView16.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.ind){
                    imageView17.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.indus){
                    imageView18.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.og){
                    imageView19.setVisibility(View.VISIBLE)
                }
            }
        }
        else{
            game_over()
        }
    }

    fun switch_right(){
        println("score = " + score)
        if (score < 6){
            println(mas[score].switch)
            if(mas[score].switch == "r"){
                score += 1
                imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mas[score].img))
                if (mas[score-1].img == R.drawable.slon_8){
                    imageView14.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.zmeya_8){
                    imageView15.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.znak){
                    imageView16.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.ind){
                    imageView17.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.indus){
                    imageView18.setVisibility(View.VISIBLE)
                }
                if (mas[score-1].img == R.drawable.og){
                    imageView19.setVisibility(View.VISIBLE)
                }
            }
        }
        else{
            game_over()
        }
    }

    fun game_over(){
        game = false
        if (score <= 5){
            textView_gameover.text = "Game Over"
        }
        else{
            textView_gameover.text = "You Win!"
        }
        textView_gameover.setVisibility(View.VISIBLE)
        imageView5.setVisibility(View.GONE)
    }
}