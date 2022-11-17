package com.softaai.dsa_kotlin.heap

import kotlin.coroutines.CoroutineContext


/**
 * Created by amoljp19 on 11/17/2022.
 * softAai Apps.
 */

fun main(){
    //maxHeap
    val array = arrayListOf<Int>(1, 12, 3, 4, 1, 6, 8, 7)

    /*val priorityQueue = ComparableHeapImpl.create(array)

    while (!priorityQueue.isEmpty){
        println(priorityQueue.remove())
    }*/


    // minHeap

    /*val insverseComparator = object : Comparator<Int>{
        override fun compare(p0: Int, p1: Int): Int = p1.compareTo(p0)
    }

    val minHeap = ComparatorHeapImpl.create(array, insverseComparator)

    while (!minHeap.isEmpty){
        println(minHeap.remove())
    }*/


    //get nth smallest Element from array

    /*val array1 = arrayListOf<Int>(3, 10, 18, 5, 21, 100)

    val insverseComparator = object : Comparator<Int>{
        override fun compare(p0: Int, p1: Int): Int = p1.compareTo(p0)
    }

    val minHeap = ComparatorHeapImpl.create(array1, insverseComparator)



    println( getNthSmallestElement(4, minHeap))
*/


}


fun getNthSmallestElement(n : Int, heap : Heap<Int>) : Int?{


    //(3, 10, 18, 5, 21, 100)

    var current = 1

    while(!heap.isEmpty){
        val element = heap.remove()
        if(current == n){
            return element
        }

        current += 1
    }

    return null

}