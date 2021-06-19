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
        val s ="hello"
        val response = firstUniqChar(s)
        Log.d("TAGGG", "result = $response")

    }

    fun firstUniqChar(s: String): Int {
        val str = s
        val array: Array<String> = str.toCharArray().map { it.toString() }.toTypedArray()
        var i = 0
        var j = 1

        if (array.size ==1){
            return 0
        } else{
            while(j < array.size){
              when {
                array[i]==array[j] -> j++

                i==array.size-2 && j ==array.size-1-> if (array[i]==array[j]){
                    return -1
                } else{
                    return i
                }



              }


            }
            return
        }

    }



}
internal class Solution {
    fun firstUniqChar(s: String): Int {
        val count = HashMap<Char, Int>()
        val n = s.length
        // build hash map : character and how often it appears
        for (i in 0 until n) {
            val c = s[i]
            count[c] = count.getOrDefault(c, 0) + 1
        }

        // find the index
        for (i in 0 until n) {
            if (count[s[i]] == 1) return i
        }
        return -1
    }
}











