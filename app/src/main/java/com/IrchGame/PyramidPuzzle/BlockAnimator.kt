package com.IrchGame.PyramidPuzzle

import android.os.Handler
import android.os.Message
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import java.util.*
import java.util.TimerTask

class BlockAnimator (borders: Borders){
    lateinit var horizontalPyramidBlock: PyramidBlock
    lateinit var verticalPyramidBlock: PyramidBlock
    lateinit var horizontalTimer:Timer
    private lateinit var horizontalTimerTask: MyTimerTask
    lateinit var verticalTimer:Timer
    private lateinit var verticalTimerTask: MyTimerTask
    var canStartHorizontalAnimation = true;
    var horizontalHandler = object: Handler(){
        override fun handleMessage(msg: Message) {
            if(canStartHorizontalAnimation) {
                horizontalPyramidBlock.move()
                if (horizontalPyramidBlock.x <= -horizontalPyramidBlock.layoutParams.width ||
                    horizontalPyramidBlock.x >= borders.rightBorder )
                    horizontalPyramidBlock.changeDirection()
            }
        }
    }
    var verticalHandler = object: Handler(){
        override fun handleMessage(msg: Message) {
            if (verticalPyramidBlock.checkGotDown()) {
                canStartHorizontalAnimation = true;
                verticalTimerTask.cancel()
                verticalPyramidBlock.scaleX = 1f
                verticalPyramidBlock.scaleY = 1.1f
            }
            else {
                verticalPyramidBlock.fall()

            }
        }
    }
    interface MyAnimator{
        fun animate()
    }

    class MyTimerTask(mAnimator: MyAnimator) : TimerTask() {
        var animator = mAnimator
        override fun run() {
            animator.animate()
        }
    }

    fun verticalAnimation(){
        this.verticalPyramidBlock = horizontalPyramidBlock
        verticalPyramidBlock.visibility = VISIBLE
        canStartHorizontalAnimation = false;
        horizontalTimerTask.cancel()
        verticalTimer = Timer()
        verticalPyramidBlock.scaleX = 0.98f
        verticalPyramidBlock.scaleY = 1.098f
        verticalTimerTask  = MyTimerTask(
            object: MyAnimator{
                override fun animate() {
                    verticalHandler.sendEmptyMessage(1)
                }
            })
        verticalTimer.schedule(verticalTimerTask, 0, 10)
    }


    fun horizontalAnimation(currentPyramidBlock: PyramidBlock){
        this.horizontalPyramidBlock = currentPyramidBlock
        currentPyramidBlock.visibility = VISIBLE
        horizontalTimer = Timer()
        horizontalTimerTask  = MyTimerTask(object: MyAnimator{
            override fun animate() {
                horizontalHandler.sendEmptyMessage(0)
            }
        })
        horizontalTimer.schedule(horizontalTimerTask, 0, 10)
    }
    fun stopAnimation(){
        verticalTimerTask  = MyTimerTask(
            object: MyAnimator {
            override fun animate() {} })
        horizontalTimerTask  = MyTimerTask(
            object: MyAnimator{
            override fun animate() {}})
         verticalTimerTask.cancel()
         horizontalTimerTask.cancel()
    }

}

