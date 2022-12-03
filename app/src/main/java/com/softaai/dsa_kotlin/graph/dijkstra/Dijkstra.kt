package com.softaai.dsa_kotlin.graph.dijkstra

import com.softaai.dsa_kotlin.graph.Edge
import com.softaai.dsa_kotlin.graph.Graph
import com.softaai.dsa_kotlin.graph.Vertex
import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyListGraph
import com.softaai.dsa_kotlin.priorityqueue.ComparatorPriorityQueueImpl


/**
 * Created by amoljp19 on 12/3/2022.
 * softAai Apps.
 */

class Dijkstra(){



    // to back track path
    fun <T> route(destination : Vertex<T>, paths : HashMap<Vertex<T>, Visit<T>>) : ArrayList<Edge<T>>{
        var vertex = destination
        val path = arrayListOf<Edge<T>>()

        loop@ while (true){
            val visit = paths[vertex] ?: break

            when(visit.visitType){
                VisitType.EDGE -> visit.edge?.let{
                    path.add(it)
                    vertex = it.source
                }
                VisitType.START -> break@loop
            }
        }

        return path
    }


    fun <T> distance(destination : Vertex<T>, paths : HashMap<Vertex<T>, Visit<T>>) : Double{
        val path = route(destination, paths)
        return path.sumOf { it.weight ?: 0.0 }
    }


    fun <T> shortestPath(start : Vertex<T>, graph : AdjacencyListGraph<T>) : HashMap<Vertex<T>, Visit<T>> {
        val paths = HashMap<Vertex<T>, Visit<T>>()

        paths[start] = Visit(VisitType.START)

        val distanceComparator = Comparator<Vertex<T>>(){first, second ->
            (distance(second, paths) - distance(first, paths)).toInt()
        }

        val priorityQueue = ComparatorPriorityQueueImpl<Vertex<T>>(distanceComparator)
        priorityQueue.enqueue(start)

        while (true){
            val vertex = priorityQueue.dequeue() ?: break

            val edges = graph.edges(vertex)

            edges.forEach {
                val weight = it.weight ?: return@forEach

                if (paths[it.destination] == null || distance(vertex, paths) + weight < distance(it.destination, paths)){
                    paths[it.destination] = Visit(VisitType.EDGE, it)
                    priorityQueue.enqueue(it.destination)
                }
            }
        }
        return paths
    }

    fun <T> shortestPath(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>) : ArrayList<Edge<T>>{
        return route(destination, paths)
    }


    // Challenge 1 - Add a method to class Dijkstra that returns a dictionary of all the shortest paths to
    //all vertices given a starting vertex.

    fun <T> getAllShortestPath(source: Vertex<T>, graph : AdjacencyListGraph<T>): HashMap<Vertex<T>,
            ArrayList<Edge<T>>> {
        val paths = HashMap<Vertex<T>, ArrayList<Edge<T>>>()
        val pathsFromSource = shortestPath(source, graph)
        graph.allVertices.forEach {
            val path = shortestPath(it, pathsFromSource)
            paths[it] = path
        }
        return paths
    }

}


class Visit<T>(val visitType : VisitType, val edge : Edge<T>? = null)

enum class VisitType{
    START,
    EDGE
}




