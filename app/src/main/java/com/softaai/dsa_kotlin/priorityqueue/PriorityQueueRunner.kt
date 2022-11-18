package com.softaai.dsa_kotlin.priorityqueue

import com.softaai.dsa_kotlin.linkedlist.example


/**
 * Created by amoljp19 on 11/18/2022.
 * softAai Apps.
 */


fun main(){

    /*"max priority queue" example {

        val priorityQueue = ComparablePriorityQueueImpl<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach{
            priorityQueue.enqueue(it)
        }

        while (!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }

    }*/



   /* "min priority queue " example {

        val comparator = object  : Comparator<String> {
            override fun compare(p0: String?, p1: String?): Int {
                val length1 = p0?.length ?: -1
                val length2 = p1?.length ?: -1
                return length2 - length1
            }
        }
        val priorityQueue = ComparatorPriorityQueueImpl(comparator)

        arrayListOf("one", "two", "three", "forty", "five", "six",
            "seven", "eight", "nine").forEach{
                priorityQueue.enqueue(it)
        }

        while(!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }
    }*/


   /* "custom sorting array list priority queue" example {
        val customSortingArrayListPriorityQueue = CustomSortingArrayListPriorityQueue<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            customSortingArrayListPriorityQueue.enqueue(it)
        }

        customSortingArrayListPriorityQueue.enqueue(5)
        customSortingArrayListPriorityQueue.enqueue(0)
        customSortingArrayListPriorityQueue.enqueue(10)

        while (!customSortingArrayListPriorityQueue.isEmpty){
            println(customSortingArrayListPriorityQueue.dequeue())
        }

    }*/


    "concert line below military" example {
        val p1 = Person("Josh", 21, true)
        val p2 = Person("Jake", 22, true)
        val p3 = Person("Clay", 28, false)
        val p4 = Person("Cindy", 28, false)
        val p5 = Person("Sabrina", 30, false)

        val priorityQueue = ComparatorPriorityQueueImpl<Person>(militaryComparator)

        arrayListOf<Person>(p1, p2, p3, p4, p5).forEach {
            priorityQueue.enqueue(it)
        }

        while(!priorityQueue.isEmpty){
            println(priorityQueue.dequeue()?.name)
        }

    }


}




/*
Your favorite concert was sold out. Fortunately, there’s a waitlist for people who still
want to go. However, the ticket sales will first prioritize someone with a military
background, followed by seniority

Given a list of people on the waitlist, you would like to prioritize the people in the
following order:
1. Military background.
2. Seniority, by age
*/

data class Person(
    val name: String,
    val age : Int,
    val isMilitary : Boolean
)


object militaryComparator : Comparator<Person>{

    override fun compare(p1: Person, p2: Person): Int {
        if(p1.isMilitary && !p2.isMilitary){
            return 1
        }
        else if (!p1.isMilitary && p2.isMilitary){
            return -1
        }
        else if (p1.isMilitary && p2.isMilitary){
            return p1.age.compareTo(p2.age)
        }
        return 0
    }

}