package com.softaai.dsa_kotlin.linkedlist

import com.softaai.dsa_kotlin.linkedlist.node.Node


/**
 * Created by amoljp19 on 9/27/2022.
 * softAai Apps.
 */

// we need to pass reference of linkedlist as we are iterating that list only
class LinkedListIterator<T>(private val list: LinkedList<T>) : MutableIterator<T> {

    private var index = 0    // to track the position in collection

    private var lastNode: Node<T>? = null  // track last node based on that we will find next node

    override fun hasNext(): Boolean {
       return index < list.size
    }

    override fun next(): T {
        if(index >= list.size) throw IndexOutOfBoundsException()

        lastNode =  if (index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }

    override fun remove() {
        if(index == 1){
            list.popFromFirst()
        }else{
            val prevNode =  list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }
}