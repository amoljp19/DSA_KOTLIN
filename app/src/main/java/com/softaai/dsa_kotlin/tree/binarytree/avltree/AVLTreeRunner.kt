package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.tree.binarytree.binarysearchtree.BinarySearchTree


/**
 * Created by amoljp19 on 11/4/2022.
 * softAai Apps.
 */

fun main(){

    val imbalancedAVL = AVLTree<Int>()

    imbalancedAVL.insert(50)
    imbalancedAVL.insert(25)
    imbalancedAVL.insert(75)
    imbalancedAVL.insert(37)
    imbalancedAVL.insert(40)


   /* "left rotation of imbalanced binary search tree" example {
        println("before left rotation tree : " + imbalancedAVL.root.toString())
        println("after left rotation tree is : " + imbalancedAVL.leftRotation(imbalancedAVL.root).toString())
    }*/
}