package com.softaai.dsa_kotlin.quicksort

import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt


/**
 * Created by amoljp19 on 11/24/2022.
 * softAai Apps.
 */

fun<T : Comparable<T>> MutableList<T>.partitionHoare(low : Int, high : Int) : Int{

    val pivote = this[low]

    var i = low - 1
    var j = high + 1

    while (true){

        do {
            i += 1
        }while (this[i] < pivote)

        do {
            j -= 1
        }while (this[j] > pivote)

        if(i < j){
            this.swapAt(i, j)
        }else{
            return j
        }

    }
}


fun<T : Comparable<T>> MutableList<T>.quickSortHoare(low : Int, high : Int){

    if (low < high){
        val newPivote = this.partitionHoare(low, high)

        quickSortHoare(low, newPivote)
        quickSortHoare(newPivote + 1, high)
    }

}