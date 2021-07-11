//package com.IrchGame
//
//import android.R.attr.button
//import android.os.Bundle
//import android.view.GestureDetector
//import android.view.MotionEvent
//import android.widget.LinearLayout
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_find_puzzle.*
//import java.util.*
//import kotlin.math.abs
//import kotlin.random.Random
//
//
//class find_puzzle : AppCompatActivity(), GestureDetector.OnGestureListener {
//
//    lateinit var gestureDetector: GestureDetector
//    var x2:Float = 0.0f
//    var x1:Float = 0.0f
//    var y2:Float = 0.0f
//    var y1:Float = 0.0f
//
//    companion object{
//        const val MIN_DISTANCE = 150
//    }
//
//    class poss(x1_1: Int, y1_1: Int, x2_2: Int, y2_2: Int, x3_3: Int, y3_3: Int, x4_4: Int, y4_4: Int) {
//        var x1 = x1_1
//        var y1 = y1_1
//
//        var x2 = x2_2
//        var y2 = y2_2
//
//        var x3 = x3_3
//        var y3 = y3_3
//
//        var x4 = x4_4
//        var y4 = y4_4
//
////        var img = img_1
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_find_puzzle)
//
//        gestureDetector = GestureDetector(this, this)
//
////        var load_1 = poss(1, 1, 1, 10, 1, 20, 1, 30)
////        var load_2 = poss(10, 1, 10, 10, 10, 20, 10, 30)
////        var load_3 = poss(20, 1, 20, 10, 20, 20, 20, 30)
////
////        create_lvl(load_2)
////
////        var rand = Random.nextInt(from = 1, until = 4)
////        if (rand == 1){
//////            create_lvl(load_1)
////        }
////
////        if (rand == 2){
//////            create_lvl(load_2)
////        }
////
////        if (rand == 3){
//////            create_lvl(load_3)
////        }
//    }
//    fun create_lvl(load: poss){
//
//        val linnear_lay = LinearLayout.LayoutParams(25, 45)
//        linnear_lay.leftMargin = load.x1
//        linnear_lay.topMargin = load.y1
//        linnear_lay.gravity = 16
//
//        button_find_1.setLayoutParams(linnear_lay)
////
////        linnear_lay.leftMargin = load.x2
////        linnear_lay.topMargin = load.y2
////        linnear_lay.gravity = 16
////
////        button_find_2.setLayoutParams(linnear_lay)
////
////        linnear_lay.leftMargin = load.x3
////        linnear_lay.topMargin = load.y3
////        linnear_lay.gravity = 16
////
////        button_find_3.setLayoutParams(linnear_lay)
////
////        linnear_lay.leftMargin = load.x4
////        linnear_lay.topMargin = load.y4
////        linnear_lay.gravity = 16
////
////        button_find_4.setLayoutParams(linnear_lay)
//    }
//
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//
//        gestureDetector.onTouchEvent(event)
//
//        when(event?.action){
//            0->{
//                x1 = event.x
//                y1 = event.y
//            }
//            1->{
//                x2 = event.x
//                y2 = event.y
//
//                val valueX:Float = x2-x1
//                val valueY:Float = y2-y1
//
//                if (abs(valueX) > Separation_Puzzle.MIN_DISTANCE){
//                    if (x2 > x1){
//                        Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
//                        println("RIGHT!")
//                    }
//                    else{
//                        Toast.makeText(this, "Left swipe", Toast.LENGTH_SHORT).show()
//                        println("LEFT!")
//
//                    }
//                }
//                else if(abs(valueY) > Separation_Puzzle.MIN_DISTANCE){
//                    if (y2 > y1){
//                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
//                        println("BOTTOM!")
//
//                    }
//                    else{
//                        Toast.makeText(this, "Top swipe", Toast.LENGTH_SHORT).show()
//                        println("TOP!")
//
//                    }
//                }
//            }
//        }
//
//        return super.onTouchEvent(event)
//    }
//
//    override fun onDown(e: MotionEvent?): Boolean {
//        //TODO("Not yet implemented")
//        return false
//    }
//
//    override fun onShowPress(e: MotionEvent?) {
//        //TODO("Not yet implemented")
//    }
//
//    override fun onSingleTapUp(e: MotionEvent?): Boolean {
//        //TODO("Not yet implemented")
//        return false
//    }
//
//    override fun onScroll(
//        e1: MotionEvent?,
//        e2: MotionEvent?,
//        distanceX: Float,
//        distanceY: Float
//    ): Boolean {
//        //TODO("Not yet implemented")
//        return false
//    }
//
//    override fun onLongPress(e: MotionEvent?) {
//        //TODO("Not yet implemented")
//    }
//
//    override fun onFling(
//        e1: MotionEvent?,
//        e2: MotionEvent?,
//        velocityX: Float,
//        velocityY: Float
//    ): Boolean {
//        //TODO("Not yet implemented")
//        return false
//    }
//}