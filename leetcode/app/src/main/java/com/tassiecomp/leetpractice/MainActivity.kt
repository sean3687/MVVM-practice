package com.tassiecomp.leetpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}

internal class LinkedList {
    var head // head of list
            : Node? = null

    /* Node Class */
    internal inner class Node     // Constructor to create a new node
        (var data: Int) {
        var next: Node? = null
    }
    fun push(new_data: Int) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        val new_node = Node(new_data)

        /* 3. Make next of new Node as head */
        new_node.next = head

        /* 4. Move the head to point to new Node */
        head = new_node
    }
    fun append(new_data: Int) {
        /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        val new_node = Node(new_data)

        /* 4. If the Linked List is empty, then make the
           new node as head */if (head == null) {
            head = Node(new_data)
            return
        }

        /* 4. This new node is going to be the last node, so
         make next of it as null */new_node.next = null

        /* 5. Else traverse till the last node */
        var last = head
        while (last!!.next != null) last = last.next

        /* 6. Change the next of last node */last.next = new_node
        return
    }
}

