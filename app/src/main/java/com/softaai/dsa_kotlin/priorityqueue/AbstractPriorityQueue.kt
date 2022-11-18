package com.softaai.dsa_kotlin.priorityqueue


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */
abstract class AbstractPriorityQueue<T> : Queue<T>  {

    abstract val heap : Heap<T>
    get

    override val count: Int
        get() = heap.count

    override val isEmpty: Boolean
        get() = heap.isEmpty

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun dequeue(): T? = heap.remove()

    override fun peek(): T? = heap.peek()
}