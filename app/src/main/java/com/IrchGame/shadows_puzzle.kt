package com.IrchGame

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shadows_puzzle.*
import kotlin.random.Random

class shadows_puzzle : AppCompatActivity() {
    // для тех, кто осмелился читать этот код
    // не пытайся его понять, тут чистые кастыли, я просто забил болт
    // я сам не очень понимаю как это блин работает
    var globs = 0
    var bag = 0
    var lamp = 0
    var clock = 0
    var plant = 0

    var imgs = arrayOfNulls<ImageView>(2)
    var elements = Array(2, { 1 })

    var numbers = Array(2, { 0 })

    var rand = 0
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shadows_puzzle)

        imgs[0] = null
        imgs[1] = null
        while (i < 2){
            rand = Random.nextInt(from = 1, until = 5)
            if (rand !in numbers){
                numbers[i] = rand
                i++
            }
        }
        if (1 in numbers){
            button_shadows_1.setVisibility(View.VISIBLE)
            if (imgs[0] == null){
                imgs[0] = imageView_shadows
                imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.globus_shadow_png))
            }
            else{
                imgs[1] = imageView2_shadows
                imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.globus_shadow_png))
                globs = 1
            }
        }
        if (2 in numbers){
            button_shadows_2.setVisibility(View.VISIBLE)
            if (imgs[0] == null){
                imgs[0] = imageView_shadows
                imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.bag_shadow_png))
            }
            else{
                imgs[1] = imageView2_shadows
                imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.bag_shadow_png))
                bag = 1
            }
        }
        if (3 in numbers){
            button_shadows_3.setVisibility(View.VISIBLE)
            if (imgs[0] == null){
                imgs[0] = imageView_shadows
                imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.clock_shadow_png))
            }
            else{
                imgs[1] = imageView2_shadows
                imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.clock_shadow_png))
                clock = 1
            }
        }
        if (4 in numbers){
            button_shadows_4.setVisibility(View.VISIBLE)
            if (imgs[0] == null){
                imgs[0] = imageView_shadows
                imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.lamp_shadow_png))

            }
            else{
                imgs[1] = imageView2_shadows
                imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.lamp_shadow_png))
                lamp = 1
            }
        }
        if (5 in numbers){
            button_shadows_5.setVisibility(View.VISIBLE)
            if (imgs[0] == null){
                imgs[0] = imageView_shadows
                imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.plant_shadow_png))

            }
            else{
                imgs[1] = imageView2_shadows
                imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.plant_shadow_png))
                plant = 1
            }
        }
    }

    fun check(){
        if (1 !in elements){
            textView.setVisibility(View.VISIBLE)
        }
    }

    fun click1(view: View){
        button_shadows_1.setVisibility(View.GONE)
        if (globs == 0){
            imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.globus_2))
            elements[0] = 0
            check()
        }
        else{
            imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.globus_2))
            elements[1] = 0
            check()
        }
    }
    fun click2(view: View){
        button_shadows_2.setVisibility(View.GONE)
        if (bag == 0){
            imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.bag))
            elements[0] = 0
            check()
        }
        else{
            imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.bag))
            elements[1] = 0
            check()
        }
    }
    fun click3(view: View){
        button_shadows_3.setVisibility(View.GONE)
        if (clock == 0){
            imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.clock))
            elements[0] = 0
            check()
        }
        else{
            imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.clock))
            elements[1] = 0
            check()
        }
    }
    fun click4(view: View){
        button_shadows_4.setVisibility(View.GONE)
        if (lamp == 0){
            imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.lamp))
            elements[0] = 0
            check()
        }
        else{
            imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.lamp))
            elements[1] = 0
            check()
        }
    }
    fun click5(view: View){
        button_shadows_5.setVisibility(View.GONE)
        if (plant == 0){
            imgs[0]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.plant))
            elements[0] = 0
            check()
        }
        else{
            imgs[1]?.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.plant))
            elements[1] = 0
            check()
        }
    }

}