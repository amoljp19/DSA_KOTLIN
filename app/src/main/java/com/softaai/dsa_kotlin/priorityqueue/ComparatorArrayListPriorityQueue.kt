package com.softaai.dsa_kotlin.priorityqueue

import java.util.Collections


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */
class ComparatorArrayListPriorityQueue<T>(
    private val comparator: Comparator<T>
) : AbstractArrayListPriorityQueue<T>() {
    override fun sort() {
        Collections.sort(elements, comparator)
    }
}