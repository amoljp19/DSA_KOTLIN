package com.softaai.dsa_kotlin.heap

import android.sax.ElementListener
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


/**
 * Created by amoljp19 on 11/17/2022.
 * softAai Apps.
 */
abstract class AbstractHeap<Element> : Heap<Element>{

    var elements : ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.first()

    private fun leftChildIndex(index: Int) = 2 * index + 1

    private fun rightChildIndex(index: Int) = 2 * index + 2

    private fun parentChildIndex(index : Int) = (index - 1) / 2


    override fun insert(element: Element) {
        elements.add(element)
        shiftUp(count - 1)
    }

    private fun shiftUp(index: Int){
        var child = index
        var parent = parentChildIndex(child)

        while(child > 0 && compare(elements[child], elements[parent]) > 0){
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentChildIndex(child)
        }
    }


    override fun remove(index: Int): Element? {
        if (isEmpty) return null

        Collections.swap(elements, 0, count-1 )
        val item = elements.removeAt(count-1)
        shiftDown(0)
        return item
    }

    private fun shiftDown(index: Int){

        var parent = index

        while (true){
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)
            var candidate = parent
            if (left < count && compare(elements[left], elements[candidate]) > 0){
                candidate = left
            }

            if(right < count && compare(elements[right], elements[candidate]) > 0){
                candidate = right   // if left < right that time we first deal with right
            }

            if (candidate == parent){
                return
            }

            Collections.swap(elements, parent, candidate)
            parent = candidate
        }

    }

    abstract fun compare(a: Element, b: Element) : Int
}


// Using Comparable Implementation

class ComparableHeapImpl<Element : Comparable<Element>> : AbstractHeap<Element>(){

    override fun compare(a: Element, b: Element): Int = a.compareTo(b)

}



// Using Comparator Implementation

class ComparatorHeapImpl<Element>(
    private val comparator: Comparator<Element>
) : AbstractHeap<Element>(){

    override fun compare(a: Element, b: Element): Int = comparator.compare(a, b)

}