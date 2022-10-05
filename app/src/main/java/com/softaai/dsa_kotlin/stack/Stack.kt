package com.softaai.dsa_kotlin.stack


/**
 * Created by amoljp19 on 10/5/2022.
 * softAai Apps.
 */
interface Stack<T> {
    fun push(element: T)

    fun pop() : T
}