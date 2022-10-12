package com.softaai.dsa_kotlin.tree


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
}


typealias Visitor<T> = (TreeNode<T>) -> Unit

