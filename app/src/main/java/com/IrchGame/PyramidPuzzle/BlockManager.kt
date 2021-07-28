package com.IrchGame.PyramidPuzzle

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.IrchGame.R
import kotlin.math.abs
import kotlin.random.Random


class BlockManager(gameLayout: ConstraintLayout, defaultView: ImageView, borders: Borders) {
    private var blockImages = listOf(R.drawable.pyramid_block1, R.drawable.pyramid_block2, R.drawable.pyramid_block3)
    var blockAnimator = BlockAnimator(borders)
    var oldDrawable = blockImages[0]
    var coordsOldBlockX = -1f
    var defaultView = defaultView
    var borders = borders
    var gameLayout = gameLayout
    var nextPyramidBlock = PyramidBlock(defaultView, getDrawable(), borders)
    var maxBlockQuantity = 5
    var blocks =  arrayOf(nextPyramidBlock, null, null, null, null)
    lateinit var currentPyramidBlock: PyramidBlock
    var gameOver = false

    fun nextBlock() {
            currentPyramidBlock = nextPyramidBlock
            nextPyramidBlock = PyramidBlock(defaultView, getDrawable(), borders)
            blocks[PyramidBlock.blocksCounter - 2] = currentPyramidBlock
            gameLayout.addView(currentPyramidBlock, View.NO_ID)
            blockAnimator.horizontalAnimation(currentPyramidBlock)

    }


    fun getDrawable(): Int {
        var newDrawable = blockImages[Random.nextInt(3)]
        while (newDrawable == oldDrawable) newDrawable = blockImages[Random.nextInt(3)]
        oldDrawable = newDrawable
        return newDrawable
    }
    fun canCreateBlock():Boolean{
        return  (currentPyramidBlock.x >= 0  &&
                    currentPyramidBlock.x <= borders.rightBorder - currentPyramidBlock.layoutParams.width )
    }
    fun clearField(){
        blocks[0]?.setImageDrawable(blocks[maxBlockQuantity - 2]?.drawable)
        blocks[0]?.x = blocks[maxBlockQuantity - 2]?.x!!
        blocks[0]?.y = borders.bottomBorder - defaultView.layoutParams.height - 75F
        for (i in 1 until maxBlockQuantity - 1){
            blocks[i]?.background = null
            gameLayout.removeView(blocks[i])
        }

        blocks[1] = blocks[maxBlockQuantity - 1]
        blocks[maxBlockQuantity - 1] = null
        PyramidBlock.blocksCounter = 3
    }
    fun isGameOver():Float{
        if (abs(currentPyramidBlock.x - coordsOldBlockX) > currentPyramidBlock.layoutParams.width / 2
            && !coordsOldBlockX.equals(-1f))
                return currentPyramidBlock.x - coordsOldBlockX
        return  0f
    }
}