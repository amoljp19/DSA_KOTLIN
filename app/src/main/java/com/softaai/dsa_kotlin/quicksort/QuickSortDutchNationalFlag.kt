package com.softaai.dsa_kotlin.quicksort

import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt


/**
 * Created by amoljp19 on 11/24/2022.
 * softAai Apps.
 */


fun <T : Comparable<T>> MutableList<T>.partitionDutchNationalFlag(low : Int, high : Int, pivoteIndex : Int) : Pair<Int, Int>{

    val pivote = this[pivoteIndex]
    var smaller = low
    var equal = low
    var larger = high

    while (equal <= larger){
        if (this[equal] < pivote){
            this.swapAt(smaller, equal)
            smaller += 1
            equal += 1
        }else if(this[equal] == pivote){
            equal += 1  //for skipping purpose it is used.
        }else{
            this.swapAt(equal, larger)
            larger -= 1
        }
    }

    return  Pair(smaller, larger)

}


fun<T : Comparable<T>> MutableList<T>.quickSortDutchNationalFlag(low : Int, high : Int){
    if (low < high){
        val middle = partitionDutchNationalFlag(low, high, high)
        quickSortDutchNationalFlag(low, middle.first - 1)
        quickSortDutchNationalFlag(middle.second+1, high)
    }
}