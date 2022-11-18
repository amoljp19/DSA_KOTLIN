package com.softaai.dsa_kotlin.priorityqueue


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */

class ComparablePriorityQueueImpl<T : Comparable<T>> : AbstractPriorityQueue<T>() {

    override val heap = ComparableHeapImpl<T>()

}



class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>(){
    override val heap = ComparatorHeapImpl<T>(comparator)
}
