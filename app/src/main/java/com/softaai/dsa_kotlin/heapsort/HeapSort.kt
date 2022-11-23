package com.softaai.dsa_kotlin.heapsort


/**
 * Created by amoljp19 on 11/23/2022.
 * softAai Apps.
 */

private fun leftChildIndex(index : Int) = 2 * index + 1

private fun rightChildIndex(index : Int) = 2 * index + 2

private fun <T> Array<T>.swapAt(i: Int, j : Int){
    val aux = this[i]
    this[i] = this[j]
    this[j] = aux
}

fun <T> Array<T>.shiftDown(index: Int, upTo : Int, comparator : Comparator<T>){
    var parent = index

    while (true){

        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)

        var candidate = parent

        if (left < upTo && comparator.compare(this[left], this[candidate])  > 0){
            candidate = left
        }

        if (right < upTo && comparator.compare(this[right], this[candidate])  > 0){
            candidate = right
        }

        if (candidate == parent){
            return
        }

        this.swapAt(parent, candidate)
        parent = candidate
    }
}


fun <T> Array<T>.heapify(comparator: Comparator<T>){
    if (this.isNotEmpty()){
        (this.size / 2 downTo 0).forEach {
            this.shiftDown(it, this.size, comparator)
        }
    }
}

fun <T> Array<T>.heapSort(comparator: Comparator<T>){
    this.heapify(comparator)
    for( index in this.indices.reversed()){
        this.swapAt(0, index)
        this.shiftDown(0, index, comparator)
    }
}


val ascending = Comparator { first: Int, second: Int ->
    when {
        first < second -> -1
        first > second -> 1
        else -> 0
    }
}


/*
* challenge 2 - Current example do sorting using decending order
* so for that we just required decending comparator only
* */

val decending = Comparator{ first : Int, second : Int ->
    when{
        first < second -> 1
        first > second -> -1
        else -> 0
    }

}
