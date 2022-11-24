package com.softaai.dsa_kotlin.quicksort


/**
 * Created by amoljp19 on 11/24/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> List<T>.quickSortNaive() : List<T>{

    if(this.size < 2) return this

    val pivote = this[this.size / 2]

    val less = this.filter { it < pivote }

    val equal = this.filter { it == pivote }

    val greater = this.filter { it > pivote }

    return less.quickSortNaive() + equal + greater.quickSortNaive()

}

