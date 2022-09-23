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
    fun pushAtHead(value: T) {
        head = Node(
            value,
            next = head
        )   // here we will assign previous head value i.e null to next node

        // when list is empty means tail is null so we add new node assign to tail
        // if tail is not null then we add new element and assign to head that is we did above
        if (tail == null) {
            tail = head
        }
        size++    // whenever new node added then size must be increased by one
    }


    // push using chaining
    // head first insertion using chaining
    fun pushingAtHead(value: T): LinkedList<T> {
        head = Node(value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    // appending new node at the last position of linkedlist
    // tail end insertion
    fun appendAtTail(value: T) {
        //1 -> 2 - > 3 -> 4
        if (isEmpty()) {
            pushAtHead(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++;
    }


    // append using chaining
    fun appendingAtTail(value: T): LinkedList<T> {
        if (isEmpty()) {
            pushAtHead(value)
            return this
        }

        tail?.next = Node(value)
        tail = tail?.next

        return this
    }


    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }


    fun insertAt(value: T, afterNode: Node<T>): Node<T>? {
        if (tail == afterNode) {
            appendAtTail(value = value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }


    fun popFromFirst(): T? {
        // two cases 1. list empty and 2. non empty()
        // in both cases value returns
        // but if non empty then size reduced by 1 position and head next reference pointing to next node

        if (!isEmpty()) {
            size--
        }

        val result = head?.value
        head =
            head?.next         // head pointing to next node and removing node is garbage collected by GC

        //suppose if we removed only one node present in list then our list become empty so we need to nullify tail as
        // as when list doesnt contain anything that time head and tail both pointing to null

        if (isEmpty()) {
            tail = null
        }

        return result
    }

    fun removeLast(): T? {
        // we need to take care of two conditions 1. when list empty and 2. when list is non empty

        // if list is empty means we need to return null value and if not then not

        val head = head ?: return null

        if(head.next == null){
            popFromFirst()       // if only one node present then directly pop that node
        }

        size--

        // but if list contains more element then we need to travrse till last node
        // initially prev and curent both points to head node and next points to head.next that is current.next
        // while each iteration we are just changing pointers and when we at last that time our current is on last node
        // and we need to assign prev.next = null as we are removing current node and also mark tail as our prev
        // and finally return current value and then current node will be garbage collected by GC

        var prev = head
        var current = head

        var next = current.next

        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null    // as initially it points to last node so removed that connection buy nullifying it
        tail = prev         // finally tail should points last element that is now prev

        return current.value
    }


    fun removeAfter(node: Node<T>) : T? {
        val result = node.next?.value    // as we want to remove node after perticular node so definetly next node should be removed

        //suppose we have 1->2->3 then afterNode = 2 then last node i.e 3 is our tail but after removing
        // we need to update our new tail node so thats why new tail node is current node that is 2
        if(node.next == tail){
            tail = node
        }

        // means afterNode middle position somewhere or at first position so we are removing means size must be reduced
        if(node.next != null){
            size--
        }

        // 1->2->3   we directly rmove 2 and points to next that is 1->3
        node.next = node.next?.next

        return result

    }


}