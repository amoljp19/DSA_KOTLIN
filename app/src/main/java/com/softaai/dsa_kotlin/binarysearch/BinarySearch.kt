package com.softaai.dsa_kotlin.binarysearch


/**
 * Created by amoljp19 on 11/11/2022.
 * softAai Apps.
 */

fun <T : Comparable<T>> ArrayList<T>.binarySearch(
    value : T,
    range: IntRange = indices
) : Int?{
    if (range.first > range.last){
        return null
    }

    // best way to find middle
    val size = range.last - range.first + 1
    val middle = range.first + size / 2

    // Note - be more carefull while handling below condition, if mismatch consition then result will get either null or something else
    return when {
        this[middle] == value -> middle
        this[middle] > value -> binarySearch( value, range.first until middle)
        else -> binarySearch(value, (middle+1)..range.last)
    }
}


fun <T : Comparable<T>> ArrayList<T>.findIndices1(value: T) : IntRange?{
   // uses O(n) time complexity

    val startIndex = indexOf(value)
    val endIndex = lastIndexOf(value)

    if(startIndex == -1 || endIndex == -1) return null

    return startIndex..endIndex
}


fun <T : Comparable<T>> ArrayList<T>.findIndices(value: T) : IntRange?{
    // uses optimized time complexity i.e O(log n) as it uses binary search algorithm to find rang boundries

    val startIndex = startIndex(value, 0..size-1) ?: return null  // use indices or 0 to size-1 , be carefule in that due to this outcome varies
    val endIndex = endIndex(value, indices) ?: return null

    return startIndex until endIndex   // here I used until so excluding endIndex  i.e < endIndex

}

fun <T : Comparable<T>> ArrayList<T>.startIndex(value: T, range : IntRange) : Int ?{
   // val size = range.last - range.first + 1
    val middleIndex = range.start + (range.last - range.start + 1) / 2

    if(middleIndex == 0 || middleIndex == size - 1){
        return if(this[middleIndex] == value){
            middleIndex
        }else{
            null
        }
    }

    return if (this[middleIndex] == value){
        if(this[middleIndex - 1] != value){
            middleIndex
        }else{
            startIndex(value, range.start until middleIndex)
        }
    }else if (value < this[middleIndex]){
        startIndex(value, range.start until middleIndex)
    }else{
        startIndex(value, (middleIndex + 1)..range.last)
    }
}


fun <T : Comparable<T>> ArrayList<T>.endIndex(value: T, range : IntRange) : Int ?{

    //val size = range.last - range.first + 1
    val middleIndex = range.start + (range.last - range.start + 1) / 2


    if(middleIndex == 0 || middleIndex == size - 1){
        return if(this[middleIndex] == value){
            middleIndex + 1  // why + 1 because we use until above, if we used .. then it will be only middleIndex
        }else{
            null
        }
    }

    return if(this[middleIndex] == value){
        if (this[middleIndex + 1] != value){   // why + 1 because we are now looking right side boundry
            middleIndex + 1
        }else{
            endIndex(value, (middleIndex + 1) .. range.last)
        }
    } else if (value < this[middleIndex]){
         endIndex(value, range.start until middleIndex)
    }else{
        endIndex(value, (middleIndex + 1)..range.last)
    }

}