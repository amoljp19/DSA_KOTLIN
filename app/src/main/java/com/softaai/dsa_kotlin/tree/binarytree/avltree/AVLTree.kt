package com.softaai.dsa_kotlin.tree.binarytree.avltree


/**
 * Created by amoljp19 on 11/3/2022.
 * softAai Apps.
 */


class AVLTree<T : Comparable<T>> {

    var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode<T>(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }


    private fun leftRotation(node: AVLNode<T>?): AVLNode<T> {

        val pivote = node?.rightChild!!

        node.rightChild = pivote.leftChild

        pivote.leftChild = node

        node.height = maxOf(node.leftHeight, node.rightHeight) + 1
        pivote.height = maxOf(pivote.leftHeight, pivote.rightHeight) + 1

        return pivote     // why we returning only pivote beacause its becoming new root of AVL Tree
    }

    private fun rightRotation(node: AVLNode<T>): AVLNode<T> {
        val pivote = node.leftChild!!

        node.leftChild = pivote.rightChild

        pivote.rightChild = node

        node.height = maxOf(node.leftHeight, node.rightHeight) + 1
        pivote.height = maxOf(pivote.leftHeight, pivote.rightHeight) + 1

        return pivote
    }

    private fun leftRightRotation(node: AVLNode<T>): AVLNode<T> {
        // first left rotation on left child of node then right rotation on node
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotation(leftChild) // update left child of node

        return rightRotation(node)
    }

    private fun rightLeftRotation(node: AVLNode<T>): AVLNode<T> {
        // first right rotation on right child of node then left rotation on node
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotation(rightChild)

        return leftRotation(node)
    }


    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                // means left side heavier so need to right rotation (if bf = 1) or leftRight rotations (if bf = -1)
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotation(node)
                } else {
                    rightRotation(node)
                }
            }
            -2 -> {
                // means right side heavier so need to do left rotation (if bf = -1) or rightLeft rotations (if bf = 1)
                if (node.rightChild?.balanceFactor == 1) {
                    rightLeftRotation(node)
                } else {
                    leftRotation(node)
                }
            }
            else -> node
        }
    }
}