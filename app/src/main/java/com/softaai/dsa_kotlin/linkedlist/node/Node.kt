package com.softaai.dsa_kotlin.linkedlist.node


/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */


// we define node of linked list as data class where it holds value and next node reference

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
