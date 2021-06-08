package com.tassiecomp.recyclerviewactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = intArrayOf(1, 3, 3, 1)
        val result = containsDuplicate(list).toString()
        Log.d("TAGG", "result $result")
    }

    fun containsDuplicate(nums: IntArray): Boolean {

        var newArrayList = arrayListOf<Int>()
        var secondArrayList = arrayListOf<Int>()

        for (i in 0..nums.size - 1) {
            newArrayList.add(nums[i])
            secondArrayList.add(nums[i])
        }

        val addAllList = secondArrayList.addAll(newArrayList)
        val unionList = secondArrayList.union(secondArrayList)

        var size1 = nums.size

        Log.d("calculate", "$size1")

        Log.d("calculate", "$newArrayList")

        var size2 = unionList.size
        Log.d("calculate", "$size2")
        if (size1 != size2) {
            return true
        } else {
            return false
        }
    }
}





