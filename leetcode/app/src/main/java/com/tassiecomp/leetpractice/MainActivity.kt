package com.tassiecomp.leetpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main = main(120)
        Log.d("TAG", "$main")

    }
}

fun main(x: Int): Int {
    val change = "$x"
    Log.d("calculate", "x = $x")

    val reversed = change.reversed()
    var str = StringBuilder()
    Log.d("calculate", "reversed = $reversed")
    for (i in reversed.indices) { //i in 0..2
        if (reversed[i] == '-') {
            str.insert(0, '-') //가장 앞 포지션에 -를 넣는다.
        } else if (reversed[i] == '0' && i == reversed.length - 1)
            str.insert(0, "")//0이라면

        else str.append(reversed[i]) //아니라면 뒤에서부터 넣는다.
    }
    Log.d("calculate", "str = $str")
    return str.toString().toInt()

}

class Solutions {
    fun reverse(x: Int): Int {
            var y = x.toLong() //long으로 바꿔야 나눌때 0 안나옴 123
            var result: Long = 0
            while (y != 0.toLong()) { //input값이 0이 아니면
                result = result * 10 + y % 10
                y = y / 10
            }
            return if (Int.MAX_VALUE < result || Int.MIN_VALUE > result) 0 else result.toInt()
    }
}



