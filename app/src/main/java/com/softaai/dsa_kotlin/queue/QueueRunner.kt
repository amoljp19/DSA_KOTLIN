package com.softaai.dsa_kotlin.queue

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.queue.implementation.ArrayListQueue
import com.softaai.dsa_kotlin.queue.implementation.StackQueue


/**
 * Created by amoljp19 on 10/7/2022.
 * softAai Apps.
 */

fun main(){

  /*  "Queue using array list " example {
        val queue = ArrayListQueue<String>()
        queue.enqueue("amol")
        queue.enqueue("rahul")
        queue.enqueue("akshay")
        queue.enqueue("dhaval")
        println(queue)
        println(queue.dequeue())
        println("next up : ${queue.peek()}")
    }*/


    "Queue using double stacks" example {
        val queue = StackQueue<String>()
        queue.enqueue("amol")
        queue.enqueue("kotlin")
        queue.enqueue("android")
        queue.enqueue("java")

        println(queue)
        //queue.dequeue()
        println(queue.dequeue())
        println("next up : ${queue.peek()}" )
    }



}