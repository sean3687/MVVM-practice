package com.tassiecomp.mvvmnewsapp

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartActivity.setOnClickListener{
            Viewmodel.launch {
                while (true){ //button눌린게 true면 still running로그 반복 프린트
                    delay(1000L) //1초 간격으로 printing
                    Log.d(TAG,"Still running")

                }
                //when new intent was created,
            }
            GlobalScope.launch {
                delay(5000L) //5초후 intent시작
                Intent(this@MainActivity, SecondActivity::class.java).also{
                    startActivity(it)
                    finish()
                }
            }
        }
    }

}