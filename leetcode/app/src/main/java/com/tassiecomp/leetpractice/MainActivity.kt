package com.tassiecomp.leetpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Node





class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var temp: Node = head

}
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val nth = getCount(head) - n
    }

    fun getCount(head:ListNode?):Int{
        val count = 0
        var temp:Node =head
        while(temp != null){
            count++
        }
        return count

    }
}







