package com.IrchGame

import kotlinx.android.synthetic.main.activity_shadows_puzzle.*
import kotlin.random.Random

fun main(args : Array<String>){
    var numbers = MutableList(5, {0})
    var rand = 0
    var i = 0
    while (i < 5){
        rand = Random.nextInt(from = 1, until = 9)
        if (rand !in numbers){
            numbers[i] = rand
            i++
        }
    }

    for (j in numbers){
        println(j)
    }
}
