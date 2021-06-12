package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers: IntArray = intArrayOf(1,2,3,4,5,6,7)
        val result = rotate(numbers,3)
        Log.d("TAGGG", "result = $result")

    }
}







