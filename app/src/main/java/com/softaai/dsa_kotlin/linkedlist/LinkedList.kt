package com.softaai.dsa_kotlin.linkedlist

import com.softaai.dsa_kotlin.linkedlist.node.Node

/**
 * Created by amoljp19 on 9/17/2022.
 * softAai Apps.
 */

// it defines LinkedList property and different operations
// as we know it has two pointers head and tail

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }


    // to print nodes in linkedlist
    override fun toString(): String {
        return if (isEmpty()) {
            "list is empty"
        } else {
            head.toString()
        }
    }


    // this function we use for inserting new element at first position in linked list
    // head-first insertion
    fun pushAtHead(value: T){
        head = Node(value, next = head)   // here we will assign previous head value i.e null to next node

        // when list is empty means tail is null so we add new node assign to tail
        // if tail is not null then we add new element and assign to head that is we did above
        if(tail == null){
            tail = head
        }
        size++    // whenever new node added then size must be increased by one
    }


    // push using chaining
    // head first insertion using chaining
    fun pushingAtHead(value: T) : LinkedList<T>{
        head = Node(value, next = head)
        if (tail == null){
            tail = head
        }
        size++
        return this
    }

    // appending new node at the last position of linkedlist
    // tail end insertion
    fun appendAtTail(value: T){
        //1 -> 2 - > 3 -> 4
       if(isEmpty()){
           pushAtHead(value)
           return
       }
       tail?.next = Node(value)
       tail = tail?.next
       size++;
    }


    // append using chaining
    fun appendingAtTail(value: T) : LinkedList<T>{
        if (isEmpty()){
            pushAtHead(value)
            return this
        }

        tail?.next = Node(value)
        tail = tail?.next

        return this
    }


}