package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}

fun main(args : Array<String>) {
    val items = listOf("apple", "banana", "kiwi")

    for(index in 0..(items.size)) {
        println("이건 item at $index is ${items[index]}")
    }
}


