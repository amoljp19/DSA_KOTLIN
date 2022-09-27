package com.softaai.dsa_kotlin.linkedlist


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

    "printing double of list elements" example{
        val list = LinkedList<Int>()
        list.pushAtHead(3)
        list.pushAtHead(2)
        list.pushAtHead(1)
        list.pushAtHead(-9)

        for(node in list){
            println("double of $node = " + (2 * node))
        }

    }

}


infix fun String.example(function: () -> Unit){
    println("----- Example of $this -----")
    function()
    println()
}