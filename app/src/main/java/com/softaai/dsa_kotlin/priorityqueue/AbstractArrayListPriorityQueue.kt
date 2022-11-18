package com.softaai.dsa_kotlin.priorityqueue


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */
abstract class AbstractArrayListPriorityQueue<T> : Queue<T> {
    protected val elements = ArrayList<T>()

    abstract fun sort()

    override val count: Int
        get() = elements.size

    override val isEmpty: Boolean
        get() = count == 0

    override fun enqueue(element: T): Boolean {
        elements.add(element)
        sort()
        return true
    }

    override fun dequeue(): T? = if(isEmpty) null else elements.removeAt(0)


    override fun peek(): T? = elements.firstOrNull()

    override fun toString(): String = elements.toString()
}