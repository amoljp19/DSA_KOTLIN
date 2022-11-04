package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.tree.binarytree.BinaryNode
import kotlin.math.max


/**
 * Created by amoljp19 on 11/3/2022.
 * softAai Apps.
 */


class AVLTree<T : Comparable<T>>{

    var root: AVLNode<T>? = null

    fun insert(value : T){
        root = insert(root, value)
    }

    private fun insert(node : AVLNode<T>?, value: T) : AVLNode<T> {
        node ?: return AVLNode<T>(value)

        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }



    private fun leftRotation(node : AVLNode<T>?) : AVLNode<T>{

        val pivote = node?.rightChild!!

        node.rightChild = pivote.leftChild

        pivote.leftChild = node

        node.height = maxOf(node.leftHeight, node.rightHeight) + 1
        pivote.height = maxOf(pivote.leftHeight, pivote.rightHeight) + 1

        return pivote     // why we returning only pivote beacause its becoming new root of AVL Tree
    }

    private fun rightRotation(node: AVLNode<T>) : AVLNode<T>{
        val pivote = node.leftChild!!

        node.leftChild = pivote.rightChild

        pivote.rightChild = node

        node.height = maxOf(node.leftHeight, node.rightHeight) + 1
        pivote.height = maxOf(pivote.leftHeight, pivote.rightHeight) + 1

        return pivote
    }
}