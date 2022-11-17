package com.softaai.dsa_kotlin.heap

import android.system.Os.remove
import kotlin.coroutines.CoroutineContext


/**
 * Created by amoljp19 on 11/17/2022.
 * softAai Apps.
 */

fun main(){
    //maxHeap
    //val array = arrayListOf<Int>(1, 12, 3, 4, 1, 6, 8, 7)

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

    // merge two heaps

/*
    val array = arrayListOf<Int>(1, 12, 3, 4, 1, 6, 8, 7)

    val maxHeap = ComparableHeapImpl.create(array)

    val array1 = arrayListOf<Int>(3, 10, 18, 5, 21, 100)

    val inverseComparator = object : Comparator<Int>{
        override fun compare(p0: Int, p1: Int): Int = p1.compareTo(p0)
    }

    val minHeap = ComparatorHeapImpl.create(array1, inverseComparator)


    maxHeap.merge(minHeap as AbstractHeap<Int>)

   */
/* val heap = ComparatorHeapImpl.create(arrayListOf(21, 10, 18, 5, 3, 100, 1), inverseComparator)
    val heap2 = ComparatorHeapImpl.create(arrayListOf(8, 6, 20, 15, 12, 11), inverseComparator)
    heap.merge(heap2 as AbstractHeap<Int>)
*//*

    while (!maxHeap.isEmpty){
        println(" ${maxHeap.remove()} ")
    }
*/



    // isMinHeap()

    /*val array1 = arrayListOf<Int>(3, 10, 18, 5, 21, 100)

    val inverseComparator = object : Comparator<Int>{
        override fun compare(p0: Int, p1: Int): Int = p1.compareTo(p0)
    }

    val minHeap = ComparatorHeapImpl.create(array1, inverseComparator)

    println(minHeap.isMinHeap())
*/

    val inverseComparator = object : Comparator<Int>{
        override fun compare(p0: Int, p1: Int): Int = p1.compareTo(p0)
    }

    val array = arrayListOf(21, 10, 18, 5, 3, 100, 1)
    val maxHeap = ComparableHeapImpl.create(array)
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator)
    println(minHeap.isMinHeap())
    println(maxHeap.isMinHeap())

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