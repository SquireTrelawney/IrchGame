package com.IrchGame.PyramidPuzzle
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.IrchGame.End_puzzle
import com.IrchGame.MainActivity
import com.IrchGame.Puzzles
import com.IrchGame.R
import kotlinx.android.synthetic.main.activity_pyramid.*
import java.util.*
import kotlin.math.abs


class PyramidActivity : AppCompatActivity() {
    private lateinit var blockManager: BlockManager
    private var backgroundAnimator = BackgroundAnimator()
    var isSky2_onBackground = true
    var score = 0
    lateinit var myIntent: Intent
    val target = 10
    lateinit var gameOverTimerTask: TimerTask
    var rotationDir = ""
    var deg = 10
    var rotateHandler = object: Handler(){
        override fun handleMessage(msg: Message) {
            if (rotationDir != "NOT" && deg < 45) {
                if (rotationDir == "LEFT")
                    blockManager.currentPyramidBlock.rotation--
                else blockManager.currentPyramidBlock.rotation++
                deg++
            }else{
                gameOverTimerTask.cancel()
                startActivity(myIntent)
                finish()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        PyramidBlock.blocksCounter = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pyramid)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        menuButton.init(Intent(this, MainActivity::class.java), this)
        scoreView.text = score.toString() + "/" + target
        blockManager = BlockManager(
            pyramid_gameLayout, defaultImage, Borders(
                pyramid_gameLayout.layoutParams.width,
                pyramid_gameLayout.layoutParams.height
            )
        )
        blockManager.nextBlock()
        myIntent = Intent(this, End_puzzle::class.java)
    }


     fun addBlock(view: View){
         if (blockManager.canCreateBlock()) {
             blockManager.blockAnimator.verticalAnimation()
             if (blockManager.isGameOver().equals(0f) && score < target - 1) {
                 blockManager.coordsOldBlockX = blockManager.currentPyramidBlock.x
                 blockManager.nextBlock()
                 if ((PyramidBlock.blocksCounter - 1) % blockManager.maxBlockQuantity == 0) {
                     backgroundAnimator.updateBackground(
                         pyramid_gameLayout,
                         pyramid_fakeLayout.background,
                         blockManager
                     )
                     backgroundAnimator.updateBackground(
                         pyramid_fakeLayout,
                         mainLayout.background,
                         blockManager
                     )
                     if (isSky2_onBackground) {
                         mainLayout.setBackgroundResource(R.drawable.pyramid_background_sky1)
                     } else {
                         mainLayout.setBackgroundResource(R.drawable.pyramid_background_sky2)
                     }
                     isSky2_onBackground = !isSky2_onBackground
                 }
                 score++
                 scoreView.text = score.toString() + "/" + target
             }else{
                 PyramidBlock.blocksCounter++
                 blockManager.blockAnimator.stopAnimation()
                 if(blockManager.isGameOver().equals(0f)) score++
                 myIntent.putExtra("stars", (score * 3 / target))
                 if (blockManager.isGameOver().equals(0f)){

                     scoreView.text = score.toString() + "/" + target
                     startActivity(myIntent)
                 }else{

                     if (abs(blockManager.isGameOver()) > blockManager.currentPyramidBlock.layoutParams.width) {
                         PyramidBlock.blocksCounter = -PyramidBlock.blocksCounter
                         deg = 45
                     }else{
                         if (blockManager.isGameOver() > 0) rotationDir = "RIGHT"
                         else if(blockManager.isGameOver() < 0) rotationDir = "LEFT"
                         else rotationDir = "NOT"
                     }
                     var gameOverTimer = Timer()

                     gameOverTimerTask = object: TimerTask(){
                         override fun run() {
                             if (blockManager.currentPyramidBlock.checkGotDown()){
                                 rotateHandler.sendEmptyMessage(0)
                             }
                         }
                     }
                     gameOverTimer.schedule(gameOverTimerTask, 0, 20)
                 }


             }
         }
    }

    override fun onBackPressed(){
        blockManager.blockAnimator.stopAnimation()
        startActivity(Intent(this, Puzzles::class.java))
        finish()
    }
}