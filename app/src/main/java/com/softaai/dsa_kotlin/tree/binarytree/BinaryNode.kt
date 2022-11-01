package com.softaai.dsa_kotlin.tree.binarytree

import java.lang.Integer.max


/**
 * Created by amoljp19 on 10/14/2022.
 * softAai Apps.
 */

typealias Visitor<T> = (T) -> Unit
class BinaryNode<T : Comparable<T>>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>
       get() = leftChild?.min ?: this

    val isBinarySearchTree : Boolean
       get() = isBst(this, min = null, max = null)


    private fun isBst(tree: BinaryNode<T>?, min : T?,  max: T?) : Boolean{
        tree ?: return true

        //println("" + (tree.value <= min))

        if (min != null && tree.value <= min){
            return false
        }

        if (max != null && tree.value > max){
            return false
        }

        return isBst(tree.leftChild, min, tree.value) && isBst(tree.rightChild, tree.value, max)
    }


    fun traverseInOrder(visit: Visitor<T>){
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>){
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun height(node: BinaryNode<T>? = this) : Int{
        return node?.let {
            1 + max(height(node.leftChild), height(node.rightChild))
        } ?: -1
    }

    fun traversePreOrderWithNull(visit: Visitor<T?>){
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(node: BinaryNode<T> = this) : MutableList<T?>{
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }

    fun deserialize(list: MutableList<T?>) : BinaryNode<T>?{

        val rootValue = list.removeAt(0) ?: return null    // due to list.removeAt(0) time complexity is O(n^2)

        val root = BinaryNode<T>(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root
    }


    fun deserializeForOptimization(list: MutableList<T?>) : BinaryNode<T>?{

        /*
        we optimized time complexity of this function to O(n) using list.removeAt(list.size-1), but how ? answer is removeAt(0) in above function  is an O(n)
        operation because, after every removal, every element after the removed element
        must shift left to take up the missing space. In contrast, list.removeAt(list.size
        - 1) is an O(1) operation.
        */

        val rootValue = list.removeAt(list.size - 1) ?: return null

        val root = BinaryNode<T>(rootValue)

        root.leftChild = deserializeForOptimization(list)
        root.rightChild = deserializeForOptimization(list)

        return root
    }


    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T>?
    {
        return deserializeForOptimization(list.asReversed())
    }

    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?,
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


