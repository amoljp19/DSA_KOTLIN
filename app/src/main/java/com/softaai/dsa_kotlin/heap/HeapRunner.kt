package com.softaai.dsa_kotlin.heap


/**
 * Created by amoljp19 on 11/17/2022.
 * softAai Apps.
 */

fun main(){
    val array = arrayListOf<Int>(1, 12, 3, 4, 1, 6, 8, 7)

    val priorityQueue = ComparableHeapImpl.create(array)

    while (!priorityQueue.isEmpty){
        println(priorityQueue.remove())
    }
}