package com.softaai.dsa_kotlin.trie

import android.provider.SyncStateContract.Helpers.insert
import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/7/2022.
 * softAai Apps.
 */

fun main(){

   /* "trie insert and contains " example {

        val trie = Trie<Char>()

        trie.insert("amol".toList())
        println("does trie conatains amol : " + trie.contains("amol".toList()))

    }*/

   /* "trie insert and contains using extentions functions " example {
        val trie = Trie<Char>()
        trie.insert("cute")
        println("cute in trie : " + trie.contains("cute"))

    }*/

   /* "trie remove " example{
        val trie = Trie<Char>()
        trie.insert("cut")
        trie.insert("cute")

        println("\n*** Before removing ***")
        assert(trie.contains("cut"))
        println("\"cut\" is in the trie " + trie.contains("cut"))
        assert(trie.contains("cute"))
        println("\"cute\" is in the trie " + trie.contains("cute"))

        println("\n*** After removing cut and cute ***")
        trie.remove("cut")
        assert(!trie.contains("cut"))
        println("\"cut\" is in the trie " + trie.contains("cut"))
        assert(trie.contains("cute"))
        //trie.remove("cute")
        println("\"cute\" is still in the trie " + trie.contains("cute"))
    }*/


    "trie prefix matching " example {
        val trie = Trie<Char>().apply {
            insert("car")
            insert("card")
            insert("care")
            insert("cared")
            insert("cars")
            insert("carbs")
            insert("carapace")
            insert("cargo")
        }

        println("\nCollections starting with \"car\"")
        val prefixedWithCar = trie.collections("car")
        println(prefixedWithCar)
        println("\nCollections starting with \"care\"")
        val prefixedWithCare = trie.collections("care")
        println(prefixedWithCare)


    }
}