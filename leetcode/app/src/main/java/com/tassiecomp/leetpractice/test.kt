package com.tassiecomp.leetpractice

import android.util.Log

fun main(args: Array<String>){
    val s = "hello"
    val count = HashMap<Char, Int>() //비어있는 hashmap을 만들어둡니다.
    val n = s.length //string에 들어있는 문자갯수

    for (i in 0 until n) { //문자갯수 만큼 반복
        val c = s[i]// i 위치에있는 문자
        count[c] = count.getOrDefault(c, 0) + 1 //count[c] c(char)를 key로 가지고있는 값을 count합니다.
        //처음만들어졌다면 default로 0을 리턴후 +1, 아니라면 기존 value값에 1추가
        Log.d("TAGG","val $c  = ${count[c]}")
    }


}