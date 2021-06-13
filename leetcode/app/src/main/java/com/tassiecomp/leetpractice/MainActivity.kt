package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = intArrayOf(6)
        val response = plusOne(array)
        Log.d("TAGGG", "result = $response")

    }

    fun plusOne(digits: IntArray): IntArray {
        val answer = arrayListOf<Int>()

        val str = (digits.joinToString().replace(",", "").replace(" ", ""))
        Log.d("TAGG", "$str")
        Log.d("TAGG", "length = ${str.length}")
        Log.d("TAGG", "position1 = ${str.get(1).toString().toInt()}")


        val test = (str.toInt() + 1).toString()
        Log.d("TAGG", "test = $test")

        var i = 0
        while (i <= test.length-1){
            val insert = test.get(i).toString().toInt()
            answer.add(insert)
            Log.d("TAGG", "$answer")
            ++i
        }

        val answerint = answer
        Log.d("TAGG", "answerint = ${answerint}")
        return answerint.toIntArray()
    }


}










