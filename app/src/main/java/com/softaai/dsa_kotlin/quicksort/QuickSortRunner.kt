package com.softaai.dsa_kotlin.quicksort

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.stack.Stack
import com.softaai.dsa_kotlin.stack.StackImpl


/**
 * Created by amoljp19 on 11/24/2022.
 * softAai Apps.
 */

fun main(){

    /*"quick sort naive" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        println("after quick sort naive :  ${list.quickSortNaive()}")
    }
*/
   /* "quick sort lomuto" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        list.quickSortLomuto(0, list.size-1)
        println("after quick sort lomuto :  ${list}")
    }*/

   /* "quick sort hoare" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        list.quickSortHoare(0, list.size-1)
        println("after quick sort hoare :  ${list}")
    }*/


    // best approach is use dutch national flag as it handles duplicates very well.

    /*"quick sort dutch national flag" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        list.quickSortDutchNationalFlag(0, list.size-1)
        println("after quick sort dutch national flag :  ${list}")
    }*/

    "quick sort iteratively" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        list.quickSortIteratively(0, list.size-1)
        println("after quick sort iteratively :  $list")
    }

 }


/*
Challenge 1: Using Iterative quick sort instead of recursion
You learned how to implement quicksort recursively. Your challenge
is to implement it iteratively. Choose any partition strategy you learned in this
chapter.
*/


fun <T : Comparable<T>> MutableList<T>.quickSortIteratively(low : Int, high : Int){
    val stack = StackImpl<Int>()
    stack.push(low)
    stack.push(high)

    while(!stack.isEmpty){
        val end = stack.pop() ?: continue
        val start = stack.pop() ?: continue

        val newPivote = this.partitionLomuto(start, end)

        if((newPivote - 1) > start){
            stack.push(start)
            stack.push(newPivote-1)
        }

        if ((newPivote+1) < end){
            stack.push(newPivote + 1)
            stack.push(end)
        }
    }

}