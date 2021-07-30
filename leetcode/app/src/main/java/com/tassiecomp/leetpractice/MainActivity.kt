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

    // A complete working Java program
    // to demonstrate deletion
    // in singly linked list
    internal class LinkedList {
        var head // head of list
                : Node? = null

        /* Linked list Node*/
        internal inner class Node(var data: Int) {
            var next: Node? = null
        }

        /* Given a key, deletes the first
       occurrence of key in
     * linked list */
        fun deleteNode(key: Int) {
            // Store head node
            var temp = head
            var prev: Node? = null

            // If head node itself holds the key to be deleted
            if (temp != null && temp.data == key) {
                head = temp.next // Changed head
                return
            }

            // Search for the key to be deleted, keep track of
            // the previous node as we need to change temp.next
            while (temp != null && temp.data != key) {
                prev = temp
                temp = temp.next
            }

            // If key was not present in linked list
            if (temp == null) return

            // Unlink the node from linked list
            prev!!.next = temp.next
        }

        /* Inserts a new Node at front of the list. */
        fun push(new_data: Int) {
            val new_node: Node = Node(new_data)
            new_node.next = head
            head = new_node
        }

        /* This function prints contents of linked list starting
       from the given node */
        fun printList() {
            var tnode = head
            while (tnode != null) {
                print(tnode.data.toString() + " ")
                tnode = tnode.next
            }
        }

        companion object {
            /* Driver program to test above functions. Ideally this
    function should be in a separate user class. It is kept
    here to keep code compact */
            @JvmStatic
            fun main(args: Array<String>) {
                val llist = LinkedList()
                llist.push(7)
                llist.push(1)
                llist.push(3)
                llist.push(2)
                println("\nCreated Linked list is:")
                llist.printList()
                llist.deleteNode(1) // Delete node with data 1
                println(
                    "\nLinked List after Deletion of 1:"
                )
                llist.printList()
            }
        }
    }
}

