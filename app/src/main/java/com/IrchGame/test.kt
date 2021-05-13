package com.IrchGame

import kotlin.random.Random

fun main(args : Array<String>){
    val mas_supp = arrayOf(0,0,0,0,0,0)
    val mas_out = arrayOf(1, 2, 3, 4, 5, 6)

    for (i in 0..5){
        var random_num = Random.nextInt(from = 1, until = 7)
        while (random_num in mas_supp){
            random_num = Random.nextInt(from = 1, until = 7)
        }
        mas_supp[i] = random_num
        if (random_num == 1){
            mas_out[i] = 1
        }
        if (random_num == 2){
            mas_out[i] = 2
        }
        if (random_num == 3){
            mas_out[i] = 3
        }

        if (random_num == 4){
            mas_out[i] = 4
        }
        if (random_num == 5){
            mas_out[i] = 5
        }
        if (random_num == 6){
            mas_out[i] = 6
        }
    }
    println(mas_out[0])
}
