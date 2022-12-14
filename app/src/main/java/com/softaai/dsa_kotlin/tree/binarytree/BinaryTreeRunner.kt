package com.softaai.dsa_kotlin.tree.binarytree


/**
 * Created by amoljp19 on 10/14/2022.
 * softAai Apps.
 */

fun main(){

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree = seven

    //println(tree)

    //tree.traverseInOrder { println(it) }

    //tree.traversePreOrder { println(it) }

    //tree.traversePostOrder { println(it) }

    //println(tree.height())

    println(tree)
    val list = tree.serialize()
    println(tree.deserializeOptimized(list))


}