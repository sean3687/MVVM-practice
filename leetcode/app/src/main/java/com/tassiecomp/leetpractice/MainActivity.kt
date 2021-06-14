package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = intArrayOf(6)
        val response = plusOne(array)
        Log.d("TAGGG", "result = $response")

    }

    fun plusOne(digits: IntArray): IntArray {
        if (digits.last() < 9) {
            Log.d(TAG, "lastdigit = ${digits.last()}")
            digits[digits.lastIndex] = digits.last() + 1
            return digits
        }
        for (i in digits.lastIndex downTo 0) {
            digits[i]++
            if (digits[i] >= 10) {
                digits[i] = 0
            } else {
                return digits
            }
        }
        return intArrayOf(1, *digits)
    }


}










