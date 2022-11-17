package com.softaai.dsa_kotlin.heap


/**
 * Created by amoljp19 on 11/16/2022.
 * softAai Apps.
 */

interface Collection<Element> {

    val count: Int
    get

    val isEmpty : Boolean
    get() = count == 0


    fun insert(element : Element)

    fun remove() : Element ?

    fun remove(index : Int) : Element?

}