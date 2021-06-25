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

        val s = "-0032"
        myAtoi(s)

    }

}


fun myAtoi(s: String): Int {
    val str = StringBuilder()
    val j =0
    val k =1
    for (i in s.indices) { //i 는 -나올때까지 반복
        if (s.get(i) == -){
            while (j<k){
                if()
            }
        }else{

        }
    }


}













