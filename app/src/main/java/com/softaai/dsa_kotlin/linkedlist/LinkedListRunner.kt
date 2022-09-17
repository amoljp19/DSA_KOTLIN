package com.softaai.dsa_kotlin.linkedlist


/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */

fun main(){
    // push operation at first position in linked list
    "push" example {

        val list = LinkedList<String>()

        list.push("amol")
        list.push("satara")
        list.push("bajirao")
        list.push("pune")

        println(list)

    }
}


infix fun String.example(function: () -> Unit){
    println("----- Example of $this -----")
    function()
    println()
}