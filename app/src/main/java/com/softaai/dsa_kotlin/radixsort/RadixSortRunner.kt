package com.softaai.dsa_kotlin.radixsort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */

fun main(){
   /* "radix sort" example {
        val list = arrayListOf<Int>(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted : $list")
    }*/


    "lexicographical sorting " example{
        val list = arrayListOf(500, 1345, 13, 459, 44, 999)
        println(list)
        //list.lexicographicalSort()
        println(list.lexicographicalSort()) // outputs [13, 1345, 44, 459, 500, 999]

    }


  /*  "MSD radix sort" example {
        val list= (0..10).map { (Math.random() *
                10000).toInt() }.toMutableList()
        println("Original: $list")
        //list.lexicographicalSort()
        println("Radix sorted: ${list.lexicographicalSort()}")
    }*/
}