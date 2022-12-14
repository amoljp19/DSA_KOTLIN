package com.softaai.dsa_kotlin.stack

import com.softaai.dsa_kotlin.linkedlist.LinkedList
import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 10/5/2022.
 * softAai Apps.
 */

fun main(){
  /*  "stack using arraylist " example{
        val stack = StackImpl<Int>()
        stack.push(2)
        stack.push(1)
        stack.push(3)
        stack.push(6)
        stack.push(9)

        println(stack)

        val popped = stack.pop()
        println("popped : $popped")
        println(stack)
    }*/


    /*"initialzing stack from list " example {
        val list = listOf("A", "B", "C", "D")
        val stack = StackImpl.create(list)
        println(stack)
        println("popped : ${stack.pop()}")
    }*/

/*
    "initialzing stack from an array literal" example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        println(stack)
        println("popped : ${stack.pop()}")
    }*/

  /*  "print linkedlist in reverse order using stack " example {
        val list = LinkedList<Int>()
        list.pushAtHead(1)
        list.pushAtHead(2)
        list.pushAtHead(3)
        list.pushAtHead(5)
        list.pushAtHead(4)

        println("$list")
        list.printInReverseOrderUsingStack()
    }*/


    "check string having balanced parentheses " example {
        println("((())((())".checkBalancedParentheses())
        println("((()))()hello(((())))".checkBalancedParentheses())
        println("((()))((()))".checkBalancedParentheses())
    }
}


// printing list in reverse order
fun <T> LinkedList<T>.printInReverseOrderUsingStack(){
    val stack = StackImpl<Int>()
    for (item in this){
        stack.push(item as Int)
    }

    while (!stack.isEmpty){
        print("${stack.pop()} ")
    }
}


// balanced parentheses problem - check string contains balanced parentheses problem

fun String.checkBalancedParentheses() : Boolean{
    val stack = StackImpl<Char>()

    for(character in this){
        when(character){
            '(' -> stack.push(character)
            ')' -> if(stack.isEmpty){
                return false
            }else{
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}



