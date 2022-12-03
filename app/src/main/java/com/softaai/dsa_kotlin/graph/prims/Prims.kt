package com.softaai.dsa_kotlin.graph.prims

import com.softaai.dsa_kotlin.graph.Edge
import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.Vertex
import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyListGraph
import com.softaai.dsa_kotlin.priorityqueue.AbstractPriorityQueue
import com.softaai.dsa_kotlin.priorityqueue.ComparatorPriorityQueueImpl


/**
 * Created by amoljp19 on 12/4/2022.
 * softAai Apps.
 */
object Prims {


    fun <T> produceMinimumSpaningTree(graph: AdjacencyListGraph<T>) : Pair<Double, AdjacencyListGraph<T>> {
        var cost = 0.0
        val mst = AdjacencyListGraph<T>()
        val visited = mutableSetOf<Vertex<T>>()

        val comparator = Comparator<Edge<T>>{first, second ->
            val firstWeight = first.weight ?: 0.0
            val secondWeight = second.weight ?: 0.0
            
            (secondWeight - firstWeight).toInt()
        }

        val priorityQueue = ComparatorPriorityQueueImpl(comparator)



        mst.copyGraph(graph)

        val start = graph.vertices.firstOrNull() ?: return Pair(cost, mst)
        visited.add(start)
        addAvailableEdges(start, graph, visited, priorityQueue)

        while (true){
            val smallestEdge = priorityQueue.dequeue() ?: break
            val  vertex = smallestEdge.destination
            if (visited.contains(vertex)) continue

            visited.add(vertex)
            cost += smallestEdge.weight ?: 0.0

            mst.add(EdgeType.UNDIRECTED, smallestEdge.source, smallestEdge.destination, smallestEdge.weight)

            addAvailableEdges(vertex, graph, visited, priorityQueue)
        }

        return Pair(cost, mst)
    }

    //helper methods
    fun <T> addAvailableEdges(vertex: Vertex<T>, graph: AdjacencyListGraph<T>, visited : Set<Vertex<T>>, priorityQueue : AbstractPriorityQueue<Edge<T>>){
        graph.edges(vertex).forEach {
            if(it.destination !in visited){
                priorityQueue.enqueue(it)
            }
        }
    }



}