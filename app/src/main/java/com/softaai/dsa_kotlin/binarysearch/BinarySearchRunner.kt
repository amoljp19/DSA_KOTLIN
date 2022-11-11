package com.softaai.dsa_kotlin.binarysearch

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/11/2022.
 * softAai Apps.
 */

fun main(){

  /*"binary search " example {

      val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105, 150)

      val search31 = array.indexOf(31)
      val binarySearch31 = array.binarySearch(31)

      println("indexOf() : $search31")

      println("binary search : $binarySearch31")

  }*/


    "binary search for a range" example {
        val array = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
        val indices = array.findIndices(5)
        println(indices)
    }

}