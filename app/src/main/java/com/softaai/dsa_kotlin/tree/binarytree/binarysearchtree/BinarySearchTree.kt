package com.softaai.dsa_kotlin.tree.binarytree.binarysearchtree

import com.softaai.dsa_kotlin.tree.binarytree.BinaryNode


/**
 * Created by amoljp19 on 10/17/2022.
 * softAai Apps.
 */


class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    fun insert(value : T){
        root = insert(root, value)
    }

    private fun insert(node : BinaryNode<T>?, value: T) : BinaryNode<T>{
        node ?: return BinaryNode(value)

        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    override fun toString(): String = root?.toString() ?: "empty tree"
}



