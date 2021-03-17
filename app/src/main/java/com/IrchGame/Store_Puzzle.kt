package com.IrchGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_store_puzzle.*

class Store_Puzzle() : AppCompatActivity() {
    var countOfDonuts = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_puzzle)
        countOfDonutsText.setText(countOfDonuts.toString())


    }
    fun clickOnDonuts(view: View) {

        if (countOfDonuts != 0){
            countOfDonuts--
            countOfDonutsText.setText(countOfDonuts.toString())
            checkEndGame()
        }
    }

    private fun checkEndGame() {
        if(countOfDonuts == 0){
            congratsText.visibility = View.VISIBLE
        }
    }
}