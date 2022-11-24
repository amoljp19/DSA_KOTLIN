package com.softaai.dsa_kotlin.quicksort

import com.softaai.dsa_kotlin.linkedlist.example


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

    "quick sort dutch national flag" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("original list $list")
        list.quickSortDutchNationalFlag(0, list.size-1)
        println("after quick sort dutch national flag :  ${list}")
    }

 }