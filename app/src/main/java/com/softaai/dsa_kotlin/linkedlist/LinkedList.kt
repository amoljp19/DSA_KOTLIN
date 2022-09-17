package com.softaai.dsa_kotlin.linkedlist

import com.softaai.dsa_kotlin.linkedlist.node.Node

/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */

// it defines LinkedList property and different operations
// as we know it has two pointers head and tail

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "list is empty"
        } else {
            head.toString()
        }
    }
}