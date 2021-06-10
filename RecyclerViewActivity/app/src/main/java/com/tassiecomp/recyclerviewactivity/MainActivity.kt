package com.tassiecomp.recyclerviewactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




}


}

internal class Solution {
    fun singleNumber(nums: IntArray): Int {
        val hash_table = HashMap<Int, Int>()
        for (i in nums) {
            hash_table[i] = hash_table.getOrDefault(i, 0) + 1
        }
        for (i in nums) {
            if (hash_table[i] == 1) {
                return i
            }
        }
        return 0
    }
}








