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

        val s = "abccccc"
        val p = "abc"
        strStr(s,p)

    }


}


fun strStr(haystack: String, needle: String): Int {
    if (haystack.length == 0 && needle.length ==0){
        return 0
    } else{
        if (haystack.contains(needle)){
            val result = haystack.indexesOf(haystack,ignoreCase = true)
            return result[0]
        } else{
            return -1
        }
    }

}
fun ignoreCaseOpt(ignoreCase: Boolean) =
    if (ignoreCase) setOf(RegexOption.IGNORE_CASE) else emptySet()
fun String?.indexesOf(pat: String, ignoreCase: Boolean = true): List<Int> =
    pat.toRegex(ignoreCaseOpt(ignoreCase))
        .findAll(this?: "")
        .map { it.range.first }
        .toList()
















