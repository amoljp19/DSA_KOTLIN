package com.softaai.dsa_kotlin.quicksort

import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt


/**
 * Created by amoljp19 on 11/24/2022.
 * softAai Apps.
 */


fun <T : Comparable<T>> MutableList<T>.quickSortLomuto(low : Int, high : Int){

    if(low < high){
        val pivote = this.partitionLomuto(low, high)

        this.quickSortLomuto(low, pivote-1)
        this.quickSortLomuto(pivote+1, high)
    }

}

fun <T : Comparable<T>> MutableList<T>.partitionLomuto(low : Int, high : Int) : Int{

    val pivote = this[high]

    var i = low

    for(j in low until high){
        if (this[j] <= pivote){
            this.swapAt(i, j)
            i += 1
        }
    }

    this.swapAt(i, high)
    return i
}