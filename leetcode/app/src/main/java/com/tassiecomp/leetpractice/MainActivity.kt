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

        var li = ListNode(5)
        var v = li.`val`
        class ListNode(var `val`: Int) {
           var next: ListNode? = null
            }

    }


}

fun deleteNode(node: ListNode?) {
    var temp = node
    var nextNode = temp?.next
    while (temp != null && nextNode != null) {
        temp.`val` = nextNode.`val`
        if (nextNode.next == null) {
            temp.next = null
            return
        }
        temp = nextNode
        nextNode = nextNode.next
    }
}