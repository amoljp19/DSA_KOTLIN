package com.softaai.dsa_kotlin.tree

import com.softaai.dsa_kotlin.queue.implementation.ArrayListQueue


/**
 * Created by amoljp19 on 10/10/2022.
 * softAai Apps.
 */

class TreeNode<T>(val value: T){
    private val children : MutableList<TreeNode<T>> = mutableListOf()

    fun add(child : TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit : Visitor<T>){
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }


    fun forEachLevelOrder(visit : Visitor<T>){
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }

        var node = queue.dequeue()

        while (node != null){
            visit(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }
}


typealias Visitor<T> = (TreeNode<T>) -> Unit

