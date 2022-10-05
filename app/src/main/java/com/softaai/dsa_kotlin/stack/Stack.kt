package com.softaai.dsa_kotlin.stack


/**
 * Created by amoljp19 on 10/5/2022.
 * softAai Apps.
 */
interface Stack<T> {
    val count : Int
    get

    val isEmpty : Boolean
    get() = count == 0

    fun push(element: T)

    fun pop() : T

    fun peek(): T?

}