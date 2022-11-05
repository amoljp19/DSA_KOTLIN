package com.softaai.dsa_kotlin.tree.binarytree.avltree



/**
 * Created by amoljp19 on 11/5/2022.
 * softAai Apps.
 */




abstract class TraversalBinaryNode<self : TraversalBinaryNode<self, T>, T : Comparable<T>> (var value: T) {

    var leftChild: self? = null
    var rightChild: self? = null

    fun travesePreOrder(visit : Visitor<T>){
        visit(value)
        leftChild?.travesePreOrder(visit)
        rightChild?.travesePreOrder(visit)
    }

    fun traverseInOrder(visit : Visitor<T>){
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePostOrder(visit : Visitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}