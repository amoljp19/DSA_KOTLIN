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
        node ?: return BinaryNode<T>(value)

        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    fun contains(value : T) : Boolean{
        root ?: return false

        var found = false
        root?.traverseInOrder {
            if (value == it){
                found = true
            }
         }
        return found
    }

    fun optimizedContains(value : T) : Boolean{
        var current = root

        while (current != null){
            if(current.value == value){
                return true
            }

           current = if(value < current.value){
                 current.leftChild
            }else{
                 current.rightChild
            }
        }
        return false
    }

    fun remove(value: T){
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when{
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null){
                    return null
                }

                if(node.leftChild == null){
                    return node.rightChild
                }

                if(node.rightChild == null){
                    return node.leftChild
                }

                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)

            }

            value < node.value ->  node.leftChild = remove(node.leftChild, value)

            else -> node.rightChild = remove(node.rightChild, value)
        }

        return node
    }

    override fun toString(): String = root?.toString() ?: "empty tree"
}



