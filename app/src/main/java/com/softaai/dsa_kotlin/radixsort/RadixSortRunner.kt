package com.softaai.dsa_kotlin.radixsort

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */

fun main(){
    "radix sort" example {
        val list = arrayListOf<Int>(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted : $list")
    }
}