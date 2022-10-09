package com.softaai.dsa_kotlin.queue

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.queue.implementation.ArrayListQueue
import com.softaai.dsa_kotlin.queue.implementation.StackQueue
import com.softaai.dsa_kotlin.stack.Stack
import com.softaai.dsa_kotlin.stack.StackImpl


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


   /* "Queue using double stacks" example {
        val queue = StackQueue<String>()
        queue.enqueue("amol")
        queue.enqueue("kotlin")
        queue.enqueue("android")
        queue.enqueue("java")

        println(queue)
        //queue.dequeue()
        println(queue.dequeue())
        println("next up : ${queue.peek()}" )
    }*/


   /* "nextplayer using queue" example{
        val queue = ArrayListQueue<String>()
        queue.enqueue("amol")
        queue.enqueue("satara")
        queue.enqueue("kotlin")
        queue.enqueue("java")
        queue.enqueue("android")

        println(queue)
        println(queue.nextPlayer())

        println(queue)
        println(queue.nextPlayer())

        println(queue)
        println(queue.nextPlayer())

        println(queue)
        println(queue.nextPlayer())


    }*/


    "reverse queue " example {
        val queue = ArrayListQueue<String>()
        queue.enqueue("amol")
        queue.enqueue("satara")
        queue.enqueue("rahul")
        queue.enqueue("india")
        queue.enqueue("pune")

        println(queue)

        println(queue.reverse())

        println(queue)
    }


}


//print nextplayer in board game

fun <T> Queue<T>.nextPlayer() : T ? {
    val person = this.dequeue()

    person?.let { this.enqueue(it) }

    return person
}


// reverse content of queues hint - stack data structure

fun <T : Any> Queue<T>.reverse() : Queue<T>{
    val st = StackImpl<T>()

    while(!this.isEmpty){
        st.push(this.dequeue()!!)
    }

    while(!st.isEmpty){
        this.enqueue(st.pop()!!)
    }
    return this
}