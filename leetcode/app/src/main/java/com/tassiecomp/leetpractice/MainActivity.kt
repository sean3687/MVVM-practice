package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers: IntArray = intArrayOf(1,2,3,4,5,6,7)
        val result = rotate(numbers,3)
        Log.d("TAGGG", "result = $result")

    }
}

fun rotate(nums: IntArray, k: Int): Unit {

    val step = k % nums.size
    var cache = nums[0]
    var i = 0
    var indexStart = 0
    var total = 0
    while(true) {
        val index = (i + step) % nums.size
        val tmp = nums[index]
        nums[index] = cache
        cache = tmp
        total ++
        if (indexStart == index) {
            if (total == nums.size) {
                break
            } else {
                i  = index + 1
                indexStart = i
                cache = nums[i]
            }
        } else {
            i = index
        }
    }
}





