package com.softaai.dsa_kotlin.mergesort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */

fun main(){
    "merge sort " example {
        val arrayList = arrayListOf<Int>(7, 2, 6, 3, 9, 1)
        println("original list : $arrayList")
        println("after merge sort : ${arrayList.mergeSort()}")
    }
}