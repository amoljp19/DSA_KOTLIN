package com.softaai.dsa_kotlin.nsqauresortinglgorithm

import com.softaai.dsa_kotlin.linkedlist.example
import com.softaai.dsa_kotlin.nsqauresortinglgorithm.bubblesort.swapAt


/**
 * Created by amoljp19 on 11/21/2022.
 * softAai Apps.
 */

fun main(){

    "right alignment of given number " example {
        val arrayList = arrayListOf(3, 4, 3, 2, 3, 1, 7, 9, 8)
        println("original list $arrayList")
        arrayList.rightAlignment(3)
        println("after right alignment $arrayList")
    }

}



/*

challenge 1 - RighAlignment (To the left, to the left)

Given a list of Comparable elements, bring all instances of a given value in the list to
the right side of the array.
Ex . [3 4 3 2 3 1 7 9 8]  ----> [4 2 1 7 9 8 3 3 3]

*/


fun <T : Comparable<T>> MutableList<T>.rightAlignment(element : T){
    if (this.size < 2) return

    var searchIndex = this.size - 2

    while (searchIndex >= 0){
        if (this[searchIndex] == element){
            var moveIndex = searchIndex

            while(moveIndex < this.size-1 && (this[moveIndex+1] != element)){
                this.swapAt(moveIndex, moveIndex+1)
                moveIndex++
            }
        }

        searchIndex--
    }
}