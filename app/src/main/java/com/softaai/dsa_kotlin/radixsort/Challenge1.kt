package com.softaai.dsa_kotlin.radixsort


/**
 * Created by amoljp19 on 11/23/2022.
 * softAai Apps.
 */

/*
import java.lang.Math.pow

fun Int.digits(): Int {
    var count = 0
    var num = this
    while (num != 0) {
        count += 1
        num /= 10
    }
    return count
}

fun Int.digit(atPosition: Int): Int? {
    val correctedPosition = (atPosition + 1).toDouble()
    if (correctedPosition > digits()) return null

    var num = this
    while (num / (pow(10.0, correctedPosition).toInt()) != 0) {
        num /= 10
    }
    return num % 10
}


fun MutableList<Int>.lexicographicalSort() : MutableList<Int> {
    val newList = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(newList)
    return this
}

private fun msdRadixSorted(list: MutableList<Int>, position: Int): MutableList<Int> {
    if (position >= list.maxDigits()) return list

    // 1
    val buckets = MutableList<MutableList<Int>>(10) { mutableListOf() }
    // 2
    val priorityBucket = arrayListOf<Int>()
    // 3
    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        buckets[digit].add(number)
    }

    val newValues = buckets.reduce { result, bucket ->
        if (bucket.isEmpty()) return@reduce result
        result.addAll(msdRadixSorted(bucket, position + 1))
        result
    }
    priorityBucket.addAll(newValues)

    return priorityBucket
}

private fun List<Int>.maxDigits(): Int {
    return this.maxOrNull()?.digits() ?: 0
}*/
