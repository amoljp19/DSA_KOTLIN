package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.tree.binarytree.binarysearchtree.BinarySearchTree


/**
 * Created by amoljp19 on 11/4/2022.
 * softAai Apps.
 */

fun main(){

   /* "repeated insertions in sequence " example {
        val tree = AVLTree<Int>()

        (0..14).forEach {
            tree.insert(it)     // in insert we apply balanced logic I mean different rotations due to that we get desired structure of avl tree in output
        }

        println(tree.root)

    }*/


    val avlTree = AVLTree<Int>()

    avlTree.insert(15)
    avlTree.insert(10)
    avlTree.insert(16)
    avlTree.insert(18)

    println(avlTree.root)
    avlTree.remove(10)
    println(avlTree.root)


}