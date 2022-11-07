package com.softaai.dsa_kotlin.trie

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/7/2022.
 * softAai Apps.
 */

fun main(){

    "trie insert and contains " example {

        val trie = Trie<Char>()

        trie.insert("amol".toList())
        println("does trie conatains amol : " + trie.contains("amol".toList()))

    }
}