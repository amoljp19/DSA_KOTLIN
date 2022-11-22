package com.softaai.dsa_kotlin.mergesort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */

fun main(){
    /*"merge sort " example {
        val arrayList = arrayListOf<Int>(7, 2, 6, 3, 9, 1)
        println("original list : $arrayList")
        println("after merge sort : ${arrayList.mergeSort()}")
    }*/

    "merge two iterables" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)
        
        println("$list1")
        println("$list2")
        val result = mergeIterables(list1, list2)

        println("$result")

    }
}




/*
 Challenge 1 - merge two iterables(specially two list)
Write a function that takes two sorted iterables and merges them into a single
iterable
* */


private fun<T> Iterator<T>.nextOrNull() : T?{
    return if (this.hasNext()) this.next() else null
}



fun<T : Comparable<T>> mergeIterables(
    first : Iterable<T>,
    second : Iterable<T>
): Iterable<T>{
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    var firstEl = firstIterator.nextOrNull()
    var secondEl = secondIterator.nextOrNull()

    val result = mutableListOf<T>()
    while (firstEl != null && secondEl != null){
        when{
            firstEl < secondEl -> {
                result.add(firstEl)
                firstEl = firstIterator.nextOrNull()
            }

            firstEl > secondEl -> {
                result.add(secondEl)
                secondEl = secondIterator.nextOrNull()
            }

            else -> {
                result.add(firstEl)
                result.add(secondEl)
                firstEl = firstIterator.nextOrNull()
                secondEl = secondIterator.nextOrNull()
            }
        }
    }

    while (firstEl != null){
        result.add(firstEl)
        firstEl = firstIterator.nextOrNull()
    }

    while (secondEl != null){
        result.add(secondEl)
        secondEl = secondIterator.nextOrNull()
    }

    return result
}













