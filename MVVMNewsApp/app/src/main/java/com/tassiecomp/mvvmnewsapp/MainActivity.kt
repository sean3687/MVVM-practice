package com.tassiecomp.mvvmnewsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation")
            withTimeout(3000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.d(TAG, "Result for i = $i : ${fib(i)}")
                    }

                }
            }

            Log.d(TAG, "Ending Long running calculation")

        }

        runBlocking {

            delay(2000L)
            job.cancel()
            Log.d(TAG, "job canceled")
        }

    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "this is the answer"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "this is the answer"
    }
}