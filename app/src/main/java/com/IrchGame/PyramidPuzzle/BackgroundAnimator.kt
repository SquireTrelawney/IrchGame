package com.IrchGame.PyramidPuzzle

import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation

class BackgroundAnimator {
    var isFieldCleared = false
    fun updateBackground(view: View, newBackground: Drawable, blockManager: BlockManager){
        var downAnimation = TranslateAnimation(0F, 0F, 0F, blockManager.borders.bottomBorder.toFloat())
        downAnimation.duration = 2500
        downAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.background = null
                if (!isFieldCleared){
                    blockManager.clearField()
                    isFieldCleared = true
                }

            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        var upAnimation = TranslateAnimation(0F, 0F, 0F, -blockManager.borders.bottomBorder.toFloat())
        upAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.background = newBackground
                isFieldCleared = false
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        upAnimation.startOffset = 2500
        upAnimation.duration = 1500
        var animationSet = AnimationSet(true)
        animationSet.addAnimation(upAnimation)
        animationSet.addAnimation(downAnimation)
        view.startAnimation(animationSet)
    }

}