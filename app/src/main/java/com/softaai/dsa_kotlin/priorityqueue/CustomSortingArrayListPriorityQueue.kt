package com.softaai.dsa_kotlin.priorityqueue

import java.util.Collections.swap


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */
class CustomSortingArrayListPriorityQueue<T : Comparable<T>> : AbstractArrayListPriorityQueue<T>() {
    override fun sort() {
        //why this custom sorting required -> it required to optimize time complexity from O(nlogn) to O(n)
        // as we know in comparable and comparator we used Collections.sort() which has time complexity O(nlogn)
        // we will optimizing it using our shifting logic and it goes to O(n)

        var index = count-2
        while (index >= 0 && elements[index+1].compareTo(elements[index]) > 0){
                swap(index, index+1)
               index--
            }
    }

    private fun swap(i : Int, j : Int){
        val temp = elements[i]
        elements[i] = elements[j]
        elements[j] = temp
    }
}