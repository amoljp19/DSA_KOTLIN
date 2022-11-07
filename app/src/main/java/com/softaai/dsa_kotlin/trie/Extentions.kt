package com.softaai.dsa_kotlin.trie


/**
 * Created by amoljp19 on 11/7/2022.
 * softAai Apps.
 */

fun Trie<Char>.insert(str:String){
    insert(str.toList())
}

fun Trie<Char>.contains(str: String) : Boolean{
   return contains(str.toList())
}

fun Trie<Char>.remove(str : String) {
    remove(str.toList())
}
