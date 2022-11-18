package com.softaai.dsa_kotlin.priorityqueue

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */


fun main(){

    /*"max priority queue" example {

        val priorityQueue = ComparablePriorityQueueImpl<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach{
            priorityQueue.enqueue(it)
        }

        while (!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }

    }*/



   /* "min priority queue " example {

        val comparator = object  : Comparator<String> {
            override fun compare(p0: String?, p1: String?): Int {
                val length1 = p0?.length ?: -1
                val length2 = p1?.length ?: -1
                return length2 - length1
            }
        }
        val priorityQueue = ComparatorPriorityQueueImpl(comparator)

        arrayListOf("one", "two", "three", "forty", "five", "six",
            "seven", "eight", "nine").forEach{
                priorityQueue.enqueue(it)
        }

        while(!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }
    }*/


    "custom sorting array list priority queue" example {
        val customSortingArrayListPriorityQueue = CustomSortingArrayListPriorityQueue<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            customSortingArrayListPriorityQueue.enqueue(it)
        }

        customSortingArrayListPriorityQueue.enqueue(5)
        customSortingArrayListPriorityQueue.enqueue(0)
        customSortingArrayListPriorityQueue.enqueue(10)

        while (!customSortingArrayListPriorityQueue.isEmpty){
            println(customSortingArrayListPriorityQueue.dequeue())
        }

    }


}