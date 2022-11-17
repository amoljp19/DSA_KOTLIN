package com.softaai.dsa_kotlin.heap


/**
 * Created by amoljp19 on 11/16/2022.
 * softAai Apps.
 */
interface Heap<Element> : Collection<Element> {

    fun peek() : Element?

    fun merge(heap: AbstractHeap<Element>)

    fun isMinHeap() : Boolean
}