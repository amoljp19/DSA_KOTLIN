package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.tree.binarytree.BinaryNode


/**
 * Created by amoljp19 on 11/3/2022.
 * softAai Apps.
 */
class AVLNode<T : Comparable<T>> {

    var leftChild: AVLNode<T>? = null
    var rightChild: AVLNode<T>? = null

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1


    val balanceFactor: Int
        get() = leftHeight - rightHeight

}