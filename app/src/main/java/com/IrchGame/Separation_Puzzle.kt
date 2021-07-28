package com.IrchGame

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_separation__puzzle.*
import kotlin.math.abs
import kotlin.random.Random




class Separation_Puzzle : AppCompatActivity(), GestureDetector.OnGestureListener {

    var game = true

    lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    var obj1: img = img("l", R.drawable.ice_fon4)
    var obj2: img = img("l", R.drawable.ice_fon5)
    var obj3: img = img("l", R.drawable.ice_fon6)
    var obj4: img = img("r", R.drawable.ice_fon1)
    var obj5: img = img("r", R.drawable.ice_fon2)
    var obj6: img = img("r", R.drawable.ice_fon3)
    var mas = arrayOf(obj1, obj2, obj3, obj4, obj5, obj6)

    var lives = 3

    var score = 0

    var score_right = 0
    var score_left = 0

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_separation__puzzle)


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
//                        Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
//                        println("Right")
                        switch_right()
                    } else {
//                        Toast.makeText(this, "Left swipe", Toast.LENGTH_SHORT).show()
//                        println("Left")
                        switch_left()
                    }
                } else if ((abs(valueX) > MIN_DISTANCE) and (game == true)) {
                    if (y2 > y1) {
//                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
                    } else {
//                        Toast.makeText(this, "Top swipe", Toast.LENGTH_SHORT).show()
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

    fun switch_left(){
            if ((score < 6)) {
                if (mas[score].switch == "l"){

                    if (score < 5) {
                        imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mas[score + 1].img))
                    }
                    if (score == 5) {
                        imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ice_fon_empty))
                    }

                    if (score_left == 0) {
                        ice_left_1.setImageResource(mas[score].img)
                        ice_left_1.setVisibility(View.VISIBLE)
                    }
                    if (score_left == 1) {
                        ice_left_2.setImageResource(mas[score].img)
                        ice_left_2.setVisibility(View.VISIBLE)
                    }
                    if (score_left == 2) {
                        ice_left_3.setImageResource(mas[score].img)
                        ice_left_3.setVisibility(View.VISIBLE)
                    }
                    score = score + 1
                    score_left = score_left + 1
                }
                else{
                    if (lives != 0){
                        if (lives == 3){
                            live1.setVisibility(View.INVISIBLE)
                        }
                        if (lives == 2){
                            live2.setVisibility(View.INVISIBLE)
                        }
                        if (lives == 1){
                            live3.setVisibility(View.INVISIBLE)
                        }
                        lives = lives - 1
                    }
                    if (lives == 0){
                        game_over()
                    }
                }
            }
        else{
            game_over()
        }
        println("score = " + score)
    }

    fun switch_right(){
        if ((score < 6)) {
            if  (mas[score].switch == "r"){
                if (score < 5) {
                    imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), mas[score + 1].img))
                }
                if (score == 5) {
                    imageView5.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ice_fon_empty))
                }

                if (score_right == 0) {
                    ice_right_2.setImageResource(mas[score].img)
                    ice_right_2.setVisibility(View.VISIBLE)
                }
                if (score_right == 1) {
                    ice_right_3.setImageResource(mas[score].img)
                    ice_right_3.setVisibility(View.VISIBLE)
                }
                if (score_right == 2) {
                    ice_right_1.setImageResource(mas[score].img)
                    ice_right_1.setVisibility(View.VISIBLE)
                }
                score = score + 1
                score_right = score_right + 1
            }
            else{
                if (lives != 0){
                    if (lives == 3){
                        live1.setVisibility(View.INVISIBLE)
                    }
                    if (lives == 2){
                        live2.setVisibility(View.INVISIBLE)
                    }
                    if (lives == 1){
                        live3.setVisibility(View.INVISIBLE)
                    }
                    lives = lives - 1
                }
                if (lives == 0){
                    game_over()
                }
            }

        }
        else{
            game_over()
        }
        println("score = " + score)
    }

    fun game_over(){
        game = false
        if (score <= 4){
//            textView_gameover.text = "Game Over"
            image_loss.setVisibility(View.VISIBLE)
        }
        else{
//            textView_gameover.text = "You Win!"
            image_win.setVisibility(View.VISIBLE)
        }
    }
}
