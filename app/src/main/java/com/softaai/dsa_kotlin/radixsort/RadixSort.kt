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


/*

 Challenge 1 - Most Significant Sort

The implementation discussed in the chapter used a least significant digit radix sort.
Your task is to implement a most significant digit (MSD) radix sort.
This sorting behavior is called lexicographical sorting and is also used for String
sorting.
For example:
var list = arrayListOf(500, 1345, 13, 459, 44, 999)
list.lexicographicalSort()
println(list) // outputs [13, 1345, 44, 459, 500, 999]

*/

fun Int.digits() : Int{
    var count = 0
    var num = this
    while (num != 0){
        count +=1
        num/=10
    }

    return count
}


fun Int.digit(atPosition : Int) : Int?{
    if (atPosition > this.digits()) return null

    var num = this
    val correctedPosition = (atPosition + 1).toDouble()

    while((num /Math.pow(10.0, correctedPosition)).toInt() != 0){
        num/=10
    }

    return num % 10
}


/*fun MutableList<Int>.maxDigits() : Int{
    return this.max().digits()
}*/

private fun List<Int>.maxDigits(): Int {
    val result = this.maxOrNull()?.digits() ?: 0
    //return this.maxOrNull()?.digits() ?: 0
    return result
}


fun MutableList<Int>.lexicographicalSort() : MutableList<Int>{
    val newList = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(newList)
    //this.addAll(msdRadixSorted(this, 0))
    return this
}


private fun msdRadixSorted(list : MutableList<Int>, position : Int) : MutableList<Int>{

    if(position >= list.maxDigits()) return list

    val buckets = arrayListOf<MutableList<Int>>().apply {
        for (i in 0..9){
            this.add(arrayListOf())
        }
    }

    val priorityBucket = arrayListOf<Int>()

    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null){
            priorityBucket.add(number)
            return@forEach
        }

        buckets[digit].add(number)
    }

    priorityBucket.addAll(
        buckets.reduce { result, bucket ->
            if (bucket.isEmpty()) return@reduce result
            result.addAll(msdRadixSorted(bucket, position+1))
            result
        }
    )

    return priorityBucket
}
