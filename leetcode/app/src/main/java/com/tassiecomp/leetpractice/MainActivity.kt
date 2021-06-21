package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s = "hello"
        val t = "elloh"

        isAnagram(s,t)

    }

}


fun isAnagram(s: String, t: String): Boolean {
    val hashMap_S = hashMapOf<Char,Int>()
    val hashMap_T = hashMapOf<Char,Int>()



    for (i in 0 until s.length){
        var string = s[i]
        hashMap_S[string] = hashMap_S.getOrDefault(string,0)+1
    }

    for(i in 0 until t.length){
        var string = t[i]
        hashMap_T[string] = hashMap_T.getOrDefault(string,0)+1
    }

    return hashMap_S.equals(hashMap_T)


}













