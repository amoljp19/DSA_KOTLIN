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



    // Imp -> remove has simple logic but tricky one
    /*
    * as we know when we want to remove any perticular node then just change last terminating flag true to false
    * so that it will indicate this not terminating now but tricky part is you can not remove that node if it has
    * children which depends on, so thats why below code contains while loop
    * it go inside if current node has 0 childrens and then remove it otherwise only by setting isTerminating flag
    * to false we are able to remove that element and is still has dependent children so we we are not removing it completely 
    * */

    fun remove(list : List<Key>){

        var current = root
        println("1 " + list.toString())
        list.forEach {
            println("in for loop " + it)
            val child = current.children[it] ?: return
            current = child
        }
        println("2 " + current.key + " " + current.isTerminating)

        if(!current.isTerminating) return

        current.isTerminating = false

        val parent = current.parent
        println("3 " + parent?.key)

        while(parent != null && current.children.isEmpty() && !current.isTerminating){
            println("in while loop " + parent.key + " " + parent.children + " " + current.key )

            parent.children.remove(current.key)
            current = parent
        }
    }


    fun collection(prefix: List<Key>) : List<List<Key>>{
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        return collection(prefix, current)
    }

    private fun collection(prefix: List<Key>, node : TrieNode<Key>?) : List<List<Key>>{
        val result = mutableListOf<List<Key>>()

        if(node?.isTerminating == true){
            result.add(prefix)
        }

        node?.children?.forEach { (key, node) ->
            result.addAll(collection(prefix + key, node))
        }

        return result
    }
}