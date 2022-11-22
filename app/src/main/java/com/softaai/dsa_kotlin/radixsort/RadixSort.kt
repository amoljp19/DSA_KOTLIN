package com.softaai.dsa_kotlin.radixsort


/**
 * Created by amoljp19 on 11/22/2022.
 * softAai Apps.
 */
fun MutableList<Int>.radixSort(){
    val base = 10

    var done = false
    var digits = 1

    while (!done){
        done = true

        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9){
                this.add(arrayListOf())
            }
        }

        this.forEach { number ->
            val remaining = number / digits
            if (remaining > 0 ){
                done = false
            }
            val digit = remaining % base
            buckets[digit].add(number)
        }

        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }


}