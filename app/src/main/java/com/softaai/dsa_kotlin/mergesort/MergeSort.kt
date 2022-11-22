package com.softaai.dsa_kotlin.mergesort


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> List<T>.mergeSort() : List<T>{
    if(this.size < 2) return this

    val middle = this.size / 2
    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()

    return merge(left, right)
}




fun<T : Comparable<T>> merge(left : List<T>, right : List<T>) : List<T>{

    var leftIndex = 0
    var rightIndex = 0

    val result = mutableListOf<T>()

    while (leftIndex < left.size && rightIndex < right.size){
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]

        if(leftElement < rightElement){
            result.add(leftElement)
            leftIndex++
        }else if(leftElement > rightElement){
            result.add(rightElement)
            rightIndex++
        }else{
            result.add(leftElement)
            leftIndex++
            result.add(rightElement)
            rightIndex++
        }
    }

    if(leftIndex < left.size){
        result.addAll(left.subList(leftIndex, left.size))
    }else if(rightIndex < right.size){
        result.addAll(right.subList(rightIndex, right.size))
    }

    return result
}
