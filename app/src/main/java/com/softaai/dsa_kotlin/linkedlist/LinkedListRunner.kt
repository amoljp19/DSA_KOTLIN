package com.softaai.dsa_kotlin.linkedlist


/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */

fun main(){
    // push operation at first position in linked list
    "push" example {

        val list = LinkedList<String>()

        list.pushAtHead("amol")
        list.pushAtHead("satara")
        list.pushAtHead("bajirao")
        list.pushAtHead("pune")

        println(list)

    }


    "fluent interface pushing" example {
        val list = LinkedList<Int>()
        list.pushingAtHead(2).pushingAtHead(3).pushingAtHead(7).pushingAtHead(1)
        println(list)
    }


}


infix fun String.example(function: () -> Unit){
    println("----- Example of $this -----")
    function()
    println()
}