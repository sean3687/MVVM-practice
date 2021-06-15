package com.tassiecomp.mvvmnewsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun moveZeroes(nums: IntArray): Unit {
        var k = 0
        var i = 0

        if (nums.size == 1) {

        } else {
            while (k < nums.size) {

                if (nums[i] == 0) {

                    if (nums[k] != 0) {
                        nums[i] = nums[k]
                        nums[k] = 0
                        i++
                        k++
                    } else {
                        k++
                    }

                } else {
                    i++
                    k++
                }
            }
        }
    }

}