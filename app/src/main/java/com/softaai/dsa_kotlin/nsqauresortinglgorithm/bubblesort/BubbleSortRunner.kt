package com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun main(){

    "bubble sort" example{
        val arrayList = arrayListOf<Int>(9, 4, 10, 3)
        println("original list $arrayList")
        arrayList.bubbleSort(true)
        println("after bubble sort list $arrayList")
    }

}