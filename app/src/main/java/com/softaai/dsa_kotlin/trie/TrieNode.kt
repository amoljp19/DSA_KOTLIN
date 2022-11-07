package com.softaai.dsa_kotlin.trie


/**
 * Created by amoljp19 on 11/7/2022.
 * softAai Apps.
 */
class TrieNode<Key : Any>(var key : Key?, var parent: TrieNode<Key>?) {
    val children: HashMap<Key, TrieNode<Key>> = HashMap()

    var isTerminating = false
}