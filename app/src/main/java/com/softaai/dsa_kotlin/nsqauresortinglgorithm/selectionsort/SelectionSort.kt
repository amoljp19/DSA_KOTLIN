package com.softaai.dsa_kotlin.nsqauresortinglgorithm.selectionsort

import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> ArrayList<T>.selectionSort(showPasses : Boolean = false){

    for(current in 0 until (this.size - 1)){
        var lowest = current
        for (other in (current+1) until this.size){
            if (this[lowest] > this[other]){
                lowest = other
            }
        }

        if(lowest != current){
            this.swapAt(lowest, current)
        }

        if(showPasses) println(this)
    }
}