package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers: IntArray = intArrayOf(1,2,3,4,5,6,7)
        val result = main(numbers,3)
        Log.d("TAGGG", "result = $result")

    }
}

fun main(nums: IntArray, k: Int): Unit {
    class Solution {
        fun rotate(nums: IntArray, k: Int) {
            val a = IntArray(nums.size)
            for (i in nums.indices) {
                a[(i + k) % nums.size] = nums[i]
            }
            for (i in nums.indices) {
                nums[i] = a[i]
            }
        }
    }
}





