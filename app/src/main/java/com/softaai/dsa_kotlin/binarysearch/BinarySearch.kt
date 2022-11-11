package com.softaai.dsa_kotlin.binarysearch


/**
 * Created by amoljp19 on 11/11/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> ArrayList<T>.binarySearch(
    value : T,
    range: IntRange = indices
) : Int?{
    if (range.first > range.last){
        return null
    }

    val middle = (range.first + range.last) / 2//range.first + size/2

    // Note - be more carefull while handling below condition, if mismatch consition then result will get either null or something else
    return when {
        this[middle] == value -> middle
        this[middle] > value -> binarySearch( value, range.first until middle)
        else -> binarySearch(value, (middle+1)..range.last)
    }
}
