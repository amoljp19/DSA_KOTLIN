package com.softaai.dsa_kotlin.priorityqueue


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */

interface Queue<T> {

    val count : Int
    get

    val isEmpty : Boolean
    get() = count == 0

    fun enqueue(element : T) : Boolean

    fun dequeue() : T?

    fun peek() : T?
}