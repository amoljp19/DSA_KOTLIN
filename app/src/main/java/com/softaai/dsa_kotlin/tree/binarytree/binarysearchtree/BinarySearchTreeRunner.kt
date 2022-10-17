package com.softaai.dsa_kotlin.tree.binarytree.binarysearchtree

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 10/17/2022.
 * softAai Apps.
 */

fun main(){

    /*"building bst " example {
        val bst = BinarySearchTree<Int>()
        (1..4).forEach{
            bst.insert(it)
        }
        println(bst)
    }
*/
    val exampleTree = BinarySearchTree<Int>()

    exampleTree.insert(3)
    exampleTree.insert(1)
    exampleTree.insert(4)
    exampleTree.insert(0)
    exampleTree.insert(2)
    exampleTree.insert(5)


    /*"building a BST" example {
        println(exampleTree)
    }*/

  /*  "finding elements in BST " example {
        if (exampleTree.contains(5)){
            println("found 5 in bst")
        } else {
            println("not found element")
        }
    }*/

    "finding elements in BST using optimized way of O(log n) " example {
        if(exampleTree.optimizedContains(5)){
            println("found 5 in BST")
        } else {
            println("not found element")
        }
    }
}