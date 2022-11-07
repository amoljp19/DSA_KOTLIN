package com.softaai.dsa_kotlin.trie

import android.inputmethodservice.Keyboard.Key


/**
 * Created by amoljp19 on 11/7/2022.
 * softAai Apps.
 */
class Trie<Key : Any> {

    private val root = TrieNode<Key>(key = null, parent = null)

    fun insert(list : List<Key>){
        var current = root
        list.forEach { element ->
          /* val child = current.children[element] ?: TrieNode(element, current)
            current.children[element] = child
            current = child*/   // new edition code

            if(current.children[element] == null){
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }

        current.isTerminating = true
    }


    fun contains(list : List<Key>): Boolean {
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return false    // if you return new trienode when it null that time by default false value we get as return ultimately 
            current = child
        }

        return current.isTerminating
    }
}