package com.softaai.dsa_kotlin.tree.binarytree.avltree

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.tree.binarytree.binarysearchtree.BinarySearchTree


/**
 * Created by amoljp19 on 11/4/2022.
 * softAai Apps.
 */

fun main(){

    "repeated insertions in sequence " example {
        val tree = AVLTree<Int>()

        (0..14).forEach {
            tree.insert(it)
        }

        println(tree.root)

    }

}