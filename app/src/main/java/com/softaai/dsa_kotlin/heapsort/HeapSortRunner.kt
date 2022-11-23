package com.softaai.dsa_kotlin.heapsort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/23/2022.
 * softAai Apps.
 */


fun main(){

    "Heap sort" example {
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        println(array.joinToString())
        array.heapSort(ascending)
        println(array.joinToString())
    }

}