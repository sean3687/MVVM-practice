package com.tassiecomp.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
//          launch can have parameter: Dispatchers.
            //main: start coroutine on main thread, useful when you deal with UI
            //IO: all kind of data operation eg. networking,writing to data base,reading and writing to file
            //Default: choose if you are planning on 1000 of calculation it should not block main thread
            //Unconfined:

            Log.d(TAG,"1")

            //we will going to write we will execute coroutine
            delay(3000L) //delay will pause the current coroutine not whole thread
            //which means this paused thread will be out of work but other thread will be keep running
            //delay is different from sleep bc sleeping is whole worker in thread is sleeping
            //while delay is loading, if we quit app what's gona happen is coroutine will be canceld
            Log.d(TAG, "2")

            //delay is suspend function and it only able to execute inside suspend function or coroutine
            doNetworkCall()// it can be only called inside coroutine
            Log.d(TAG, "3")
            doNetworkCall2() // the 2nd call is done after first call is done
            Log.d(TAG, "4")
        }
        Log.d(TAG, "5")
    }

    suspend fun doNetworkCall():String{
        delay(3000L)
        return "this is the answer"
    }
    suspend fun doNetworkCall2(): String{
        delay(3000L)
        return "this is the answer"
    }
}