package com.softaai.dsa_kotlin.stack

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 10/5/2022.
 * softAai Apps.
 */

fun main(){
    "stack using arraylist " example{
        val stack = StackImpl<Int>()
        stack.push(2)
        stack.push(1)
        stack.push(3)
        stack.push(6)
        stack.push(9)

        println(stack)

        val popped = stack.pop()
        println("popped : $popped")
        println(stack)
    }
}