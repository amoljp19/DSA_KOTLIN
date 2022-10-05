package com.softaai.dsa_kotlin.stack


/**
 * Created by amoljp19 on 10/5/2022.
 * softAai Apps.
 */
class StackImpl<T : Any> : Stack<T>{

    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----Top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("----------")
    }

    override fun push(element: T) {
       storage.add(element)
    }

    override fun pop(): T {
        if(storage.size == 0){
            throw Exception("stack is empty now")
        }else{
            return storage.removeAt(storage.size-1)
        }
    }

}