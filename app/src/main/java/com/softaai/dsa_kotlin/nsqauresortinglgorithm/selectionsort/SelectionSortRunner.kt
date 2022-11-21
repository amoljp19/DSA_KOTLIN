package com.softaai.dsa_kotlin.nsqauresortinglgorithm.selectionsort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun main(){

    "selection sort" example{
        val arrayList = arrayListOf(9, 4, 10, 3)
        println("original list $arrayList")
        arrayList.selectionSort(true)
        println("list after selection sort $arrayList")
    }
}