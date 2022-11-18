package com.softaai.dsa_kotlin.priorityqueue

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */


fun main(){

    "max priority queue" example {

        val priorityQueue = ComparablePriorityQueueImpl<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach{
            priorityQueue.enqueue(it)
        }

        while (!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }

    }
}