package com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> ArrayList<T>.swapAt(i : Int, j : Int){
    val aux = this[i]
    this[i] = this[j]
    this[j] = aux
}