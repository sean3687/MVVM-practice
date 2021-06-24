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

        val s = "A man, a plan, a canal: Panama"
        isPalindrome(s)

    }

}


fun isPalindrome(s: String): Boolean{
    val regex = Regex("[^A-Za-z0-9]")
    val result = regex.replace(s, "").toLowerCase()
    result.filter { !it.isWhitespace() }
    return result.reversed() == result

}













