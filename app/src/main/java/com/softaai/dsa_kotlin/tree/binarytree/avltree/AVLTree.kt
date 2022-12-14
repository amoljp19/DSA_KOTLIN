package com.softaai.dsa_kotlin.tree.binarytree.avltree

import kotlin.math.pow


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

        val balancedNode = balanced(node)

        balancedNode.height = maxOf(balancedNode.leftHeight, balancedNode.rightHeight ) + 1

        return balancedNode
    }

    fun remove(value: T){
        root = remove(root, value)
    }

    private fun remove(node: AVLNode<T>?, value: T): AVLNode<T>? {
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

        val balancedNode = balanced(node)
        balancedNode.height = maxOf(balancedNode.leftHeight, balancedNode.rightHeight) + 1

        return balancedNode
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

    //challenges

    /*
       1. How many leaf nodes are there in a perfectly balanced tree of height 3? What about
         a perfectly balanced tree of height h?

         answer - I feel it will be leaf node count = 2^h, so 8
     */

   /* val leafNodesCount : Int
       get() = Math.pow(2.0, root?.height?.toDouble()!!).toInt()
*/
    // or

    fun leafNodes(height : Int) : Int{
         return 2.0.pow(height).toInt()
    }


    /*
        2. How many nodes are there in a perfectly balanced tree of height 3? What about a
           perfectly balanced tree of height h?

           answer - 16 8 4 2 1

           2(2^h) - 1, so h=1 -> 3, h=2 -> 7, h=3 -> 15
     */

    fun totalNodesCount(height: Int) : Int{
        return 2.0.pow(height + 1).toInt() - 1

        //( 2 * ( 2.0.pow(height).toInt() ) - 1 )      // mine logic and its working fine
        // above both logic gives answer in O(1)
    }

    // time compexity is O(height)
    fun nodes(height: Int): Int {
        var totalNodes = 0
        (0..height).forEach { currentHeight ->
            totalNodes += 2.0.pow(currentHeight).toInt()
        }
        return totalNodes
    }

    /*
     dry run above function

     h=3 tn = 0
     so 0 .. 3
     h = 0  -> tn = 0 + 1
     h = 1 -> tn = 1 + 2
     h = 2 -> tn = 3 + 4
     h = 3 -> tn = 7 + 8

    * */
}