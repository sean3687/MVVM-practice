package com.tassiecomp.leetpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


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


// A simple Java program to introduce a linked list
internal class LinkedList {
    var head // head of list
            : Node? = null

    /* Linked list Node.  This inner class is made static so that
       main() can access it */
    internal class Node     // Constructor
        (var data: Int) {
        var next: Node? = null
    }

    companion object {
        /*LinkedList를 만들어보겠습니다.*/
        @JvmStatic
        fun main(args: Array<String>) {
            /* 빈 LinkedList를 먼저 만들어주겠습니다. */
            val llist = LinkedList()
            //head를 1로 해주고
            llist.head = Node(1)
            //Node들을 val에 넣어주었습니다.
            val second = Node(2)
            val third = Node(3)

            /* 이제 각 linkedList들의 node를 연결해보겠습니다.

          llist.head        second              third
             |                |                  |
             |                |                  |
         +----+------+     +----+------+     +----+------+
         | 1  | null |     | 2  | null |     |  3 | null |
         +----+------+     +----+------+     +----+------+ */
            llist.head!!.next =
                second // 첫번쨰 node를 2번쨰 node와 연결

            /*  위와코드와같이 llist.head의 다음을 second 노드로 설정해주면 아래와같이 연결됩니다.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */
            second.next =
                third // 두번째 노드를 3번째 노드와 연결

            /*  second는 third와 연결해주겠습니다.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */
        }
    }


    fun insertAfter(prev_node: Node?, new_data: Int) {
        /* 1. Node가 null인지 확인합니다.  */
       //prev_node는 C ABCD
        //new_date는 E ABECD
        if (prev_node == null) {
            println("The given previous node cannot be null")
            return
        }

        /* 2. val new_node를 new_data 로 지정합니다.
    3. 새로 넣어줄 new_data가 노드가 됩니다.*/
        val new_node = Node(new_data) //E

        /* 4. new_node 다음에 올 node는 현C의 다음자리 D  */
        new_node.next = prev_node.next //

        /* 5. prev_node의 다음자리는 new_node */
        prev_node.next = new_node
    }

    /* Appends a new node at the end.  This method is
   defined inside LinkedList class shown above */
    fun append(new_data: Int) {
        /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        val new_node = Node(new_data)

        /* 4.  */
        if (head == null) {
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