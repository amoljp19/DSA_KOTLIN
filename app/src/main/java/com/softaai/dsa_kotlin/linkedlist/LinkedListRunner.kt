package com.softaai.dsa_kotlin.linkedlist

import com.softaai.dsa_kotlin.linkedlist.node.Node
import com.softaai.dsa_kotlin.linkedlist.node.printInReverse


/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */

fun main(){
    // push operation at first position in linked list
   /* "push" example {

        val list = LinkedList<String>()

        list.pushAtHead("amol")
        list.pushAtHead("satara")
        list.pushAtHead("bajirao")
        list.pushAtHead("pune")

        println(list)

    }*/

   /* "fluent interface pushing" example {
        val list = LinkedList<Int>()
        list.pushingAtHead(2).pushingAtHead(3).pushingAtHead(7).pushingAtHead(1)
        println(list)
    }
*/

    /*"append" example{
        val list = LinkedList<Int>()

        list.appendAtTail(1)
        list.appendAtTail(2)
        list.appendAtTail(3)
        list.appendAtTail(4)

        println(list)
    }*/

   /* "fluent interface append" example {
        val list = LinkedList<Int>()

        list.appendingAtTail(2).appendingAtTail(1).appendingAtTail(3).appendingAtTail(4)

        println(list)
    }*/

  /*  "linked list insert At perticular index " example {

        val list = LinkedList<Int>()
        list.pushAtHead(1)
        list.pushAtHead(2)
        list.pushAtHead(3)

        println("list before insert $list")

        var middleNode = list.nodeAt(1)!!

        for(i in 1..3){
            middleNode = list.insertAt(-1 * i, middleNode)!!
        }

        println("After inserting $list")
    }*/

   /*"pop node from first position " example{
       val list = LinkedList<Int>()
       list.pushAtHead(3)
       list.pushAtHead(2)
       list.pushAtHead(1)

       println("list before pop $list")
       val poppedValue = list.popFromFirst()
       println("list after pop $list")
       println("popped node value $poppedValue")
   }*/

   /*"remove last node from list" example {
       val list = LinkedList<Int>()
       list.pushAtHead(3)
       list.pushAtHead(2)
       list.pushAtHead(1)

       println("list before removing last element $list")

       val removedLast = list.removeLast()

       println("list after removed last node $list")

       println("removed last node value $removedLast")
   }*/

   /*"remove after node " example {
       val list = LinkedList<Int>()
       list.pushAtHead(3)
       list.pushAtHead(2)
       list.pushAtHead(1)
       
       println("before removeAfterNode called $list")

       val index = 1
       val afterNode = list.nodeAt(index-1)
       val removedNode = list.removeAfter(afterNode!!)

       println("after removeAfterNode called $list")
       println("removedNode $removedNode")
   }*/

  /*  "printing double of list elements" example{
        val list = LinkedList<Int>()
        list.pushAtHead(3)
        list.pushAtHead(2)
        list.pushAtHead(1)
        list.pushAtHead(-9)

        for(node in list){
            println("double of $node = " + (2 * node))
        }

    }*/


  /*  "removing elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        println(list)
        list.remove(1)
        println(list)
    }
    "retaining elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.retainAll(listOf(3, 4, 5))
        println(list)
    }
    "remove all elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.removeAll(listOf(3, 4, 5))
        println(list)
    }*/


   /* "print in reverse" example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.printInReverse()
    }*/

  /*  "middle node in list" example {
        val list = LinkedList<Int>()
        list.pushAtHead(1)
        list.pushAtHead(2)
        list.pushAtHead(3)
        list.pushAtHead(4)
        list.pushAtHead(5)
        //list.pushAtHead(6)

        println(list)

        println("middle : " + list.getMiddleNode()?.value )
    }*/


    "reverse linked list by node references" example {
        val list = LinkedList<Int>()
        list.pushAtHead(3)
        list.pushAtHead(1)
        list.pushAtHead(4)
        list.pushAtHead(5)
        list.pushAtHead(2)

        println("original list : $list")
        println("reversed list : ${list.reverse()}")   //dont use reversed() it will give result like [3,1,4,5,2]
    }

}


infix fun String.example(function: () -> Unit){
    println("----- Example of $this -----")
    function()
    println()
}

fun <T> LinkedList<T>.printInReverse(){
    this.nodeAt(0)?.printInReverse()
}

fun <T> LinkedList<T>.getMiddleNode() : Node<T>? {

    var slowPointer = this.nodeAt(0)
    var fastPointer = this.nodeAt(0)

    while(fastPointer != null){
        fastPointer = fastPointer.next
        if (fastPointer != null){
            fastPointer = fastPointer.next
            slowPointer = slowPointer?.next
        }
    }

    return slowPointer
}


fun <T> addInReverse(list: LinkedList<T>, node: Node<T>){
    // 3 4 5 6
    val next = node.next
    if (next != null){
        addInReverse(list, next)
    }

    list.appendAtTail(node.value)   // we cannot append next because at the end it will become null so list should starts from last element and not with null
}


fun <T> LinkedList<T>.reverse() : LinkedList<T>{
    val result = LinkedList<T>()   // this for new reversed list as we pass head, it we process and append from end to result list
    val head = this.nodeAt(0)
    if(head != null){
        addInReverse(result, head)
    }

    return result


}

