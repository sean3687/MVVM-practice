package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s = "hello"
//        val response = firstUniqChar(s)
//        Log.d(TAG, "result = $response")

    }

}


class Solution {
    fun firstUniqChar(s: String): Int {
        val hashMap = HashMap<Char, Int>() //비어있는 hashmap을 리턴합니다.
        val size = s.length
        for (i in 0 until size) {
//            val count =
        }
        return 1
    }
}












