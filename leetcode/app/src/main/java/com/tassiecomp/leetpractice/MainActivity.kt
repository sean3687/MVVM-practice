package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = intArrayOf(0,1,0,3,12)
        val response = moveZeroes(array)
        Log.d("TAGGG", "result = $response")

    }

    fun moveZeroes(nums: IntArray): Unit {
        var k = 0 //
        var i = 0 //

        while (k < nums.size || i < nums.size) {
            if (nums[i] == 0) {

                if (nums[k] != 0) {
                    nums[i] = nums[k]
                    nums[k] = 0
                    i++
                    k++
                } else{
                    k++
                }

            } else{
                i++
            }
            Log.d(TAG,"${nums.joinToString()}")
        }
        Log.d(TAG,"${nums.joinToString()}")
    }


}










