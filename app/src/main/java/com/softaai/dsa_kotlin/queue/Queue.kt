package com.softaai.dsa_kotlin.queue


/**
 * Created by amoljp19 on 10/7/2022.
 * softAai Apps.
 */

interface Queue<T>{

    fun enqueue(element : T) : Boolean

    fun dequeue() : T?

    var count: Int
        get

    val isEmpty : Boolean
    get() = count == 0

    fun peek() : T?
}