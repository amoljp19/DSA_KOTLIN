package com.softaai.dsa_kotlin.queue.implementation

import com.softaai.dsa_kotlin.queue.Queue
import com.softaai.dsa_kotlin.stack.StackImpl


/**
 * Created by amoljp19 on 10/8/2022.
 * softAai Apps.
 */
class StackQueue<T : Any> : Queue<T> {
    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.pop()
    }

    override val count: Int
        get() = leftStack.count + rightStack.count


    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }

    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: \n$rightStack"
    }

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

}