package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = "hello".toCharArray()
        val response = reverseString(array)
        Log.d("TAGGG", "result = $response")

    }
    fun reverseString(s: CharArray): Unit {
        val reversed: StringBuilder = StringBuilder(s.reverse().toString())
        Log.d(TAG, "${reversed.toCharArray()}")
    }


}











