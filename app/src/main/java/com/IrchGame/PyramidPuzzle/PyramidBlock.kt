package com.IrchGame.PyramidPuzzle

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

open class PyramidBlock: androidx.appcompat.widget.AppCompatImageView {
    private var direction = if (Random.nextInt(2) == 0) "toRight" else "toLeft"
    var borders: Borders
    companion object{
        var blocksCounter = 0
        var startGround = 75
    }
    constructor(defaultView: ImageView, drawable: Int, borders: Borders) : super(defaultView.context){
        blocksCounter++
        setImageResource(drawable)
        layoutParams = ConstraintLayout.LayoutParams(defaultView.layoutParams.width, defaultView.layoutParams.height)
        visibility = INVISIBLE
//        scaleY = 1.1F
        this.borders = borders
        y = 250F
        x = if (direction == "toLeft") borders.rightBorder.toFloat()
        else -defaultView.layoutParams.width.toFloat()
    }

    fun checkGotDown(): Boolean {
        return y >= borders.bottomBorder - layoutParams.height * ((blocksCounter  - 3) % 7 + 1) - startGround
    }

    fun changeDirection(){
        direction = if (direction == "toLeft") "toRight" else "toLeft"
    }
    fun move(){
        if (direction == "toLeft") x -= 5
        else x += 5
    }
    fun fall(){
            y += 15
    }

}