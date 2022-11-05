package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.tree.binarytree.BinaryNode




/**
 * Created by amoljp19 on 11/3/2022.
 * softAai Apps.
 */

// as here we are passing self as AVLNode<T> because AVLNode extends TraversalBinaryNode so it has
// relation so finally it is of type TravarsalBinaryNode<self : TraversalBinaryNode<self, T>>

typealias Visitor<T> = (T) -> Unit

class AVLNode<T : Comparable<T>> (value: T) : TraversalBinaryNode<AVLNode<T>, T>(value) {

    // var leftChild: AVLNode<T>? = null
    // var rightChild: AVLNode<T>? = null

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1


    val balanceFactor: Int
        get() = leftHeight - rightHeight

    val min : AVLNode<T>
        get() = leftChild?.min ?: this

    override fun toString() = diagram(this)

    private fun diagram(node: AVLNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")

            }
        } ?: "${root}null\n"
    }

}