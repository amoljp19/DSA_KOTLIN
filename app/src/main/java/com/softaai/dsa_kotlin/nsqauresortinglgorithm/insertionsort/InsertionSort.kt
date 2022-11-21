package com.softaai.dsa_kotlin.nsqauresortinglgorithm.insertionsort

import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt
import java.util.Collections


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> MutableList<T>.insertionSort(showPasses : Boolean = true){

    if(this.size < 2) return

    for(current in 1 until this.size){
        for (shifting in (1..current).reversed()){
            if(this[shifting] < this[shifting-1]){
                this.swapAt(shifting, shifting-1)
            }
        }
        if (showPasses) println(this)
    }

}