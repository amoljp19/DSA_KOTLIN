package com.softaai.dsa_kotlin.queue.implementation

import com.softaai.dsa_kotlin.queue.Queue


/**
 * Created by amoljp19 on 10/7/2022.
 * softAai Apps.
 */
class ArrayListQueue<T> : Queue<T> {
    val list = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    override var count: Int
        get() = list.size
        set(value) {}

    override fun peek(): T? {
        return list.firstOrNull()
    }

    override fun toString(): String  = list.toString()
}