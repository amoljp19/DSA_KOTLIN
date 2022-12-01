package com.softaai.dsa_kotlin.graph.adjacencylist

import com.softaai.dsa_kotlin.graph.Edge
import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.Graph
import com.softaai.dsa_kotlin.graph.Vertex
import com.softaai.dsa_kotlin.queue.implementation.StackQueue


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */
class AdjacencyListGraph<T> : Graph<T> {

    private val adjacencies = HashMap<Vertex<T>, ArrayList<Edge<T>>>()


    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdges(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUnDirectedEdges(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdges(source, destination, weight)
        addDirectedEdges(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when(edge){
            EdgeType.DIRECTED -> addDirectedEdges(source, destination, weight)
            EdgeType.UNDIRECTED -> addUnDirectedEdges(source,destination,weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination == destination }?.weight
    }


    override fun toString(): String {
        return buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString{
                    it.destination.data.toString()
                }
                append("\"${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }




    /*

Challenge 1 - Find the number of path between two vertex in graph
Write a method to count the number of paths between two vertices in a directed
graph. The example graph below has 5 paths from A to E:

    B     D
A              E
    C
*/


    fun numberOfPaths(source : Vertex<T>, destination : Vertex<T>) : Int{

        val numberOfPaths = Ref(0)
        val visited = mutableSetOf<Vertex<T>>()
        path(source, destination, visited, numberOfPaths)

        return numberOfPaths.data
    }


    fun path(source: Vertex<T>, destination: Vertex<T>, visited : MutableSet<Vertex<T>>, pathCount : Ref<Int>){
        println("Path ${pathCount.data} between ${source.data} and ${destination.data}")
        visited.add(source)
        if(source == destination){
            pathCount.data += 1
        }
        else{
            val neighbors = edges(source)
            neighbors.forEach {edge ->
               if (edge.destination !in visited){
                   path(edge.destination, destination, visited, pathCount)
               }
            }
        }

        visited.remove(source)
    }



    // BREADTH FIRST SEARCH ALGORITHM

    override fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = StackQueue<Vertex<T>>()
        val enqeued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqeued.add(source)

        while (true){
            val vertex = queue.dequeue() ?: break

            visited.add(vertex)

            val neighborsEdges = edges(vertex)
            neighborsEdges.forEach {
                if (!enqeued.contains(it.destination)){
                    queue.enqueue(it.destination)
                    enqeued.add(it.destination)
                }
            }
        }

        return visited
    }


    //Challenge 1 -> Maximum number of item in queue ever in given graph is
    // logic we need to do breath first search and then track each level queue count (maximum)

    fun getMaximunCountInQueueEver(source : Vertex<T>) : Int{
        var maxCountEverInQueue = 0;

        val queue = StackQueue<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        while (true){
            val vertex = queue.dequeue() ?: break
            visited.add(vertex)

            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if(!enqueued.contains(it.destination)){
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
            if (maxCountEverInQueue < queue.count){
                maxCountEverInQueue = queue.count
            }
        }

        return maxCountEverInQueue
    }


    //challenge 2 -> implement breadth first search using recursion

    fun breadthFirstSearchUsingRecursion(source : Vertex<T>) : ArrayList<Vertex<T>>{
        val queue = StackQueue<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        bfs(queue, enqueued, visited)

        return visited
    }


    fun bfs(queue: StackQueue<Vertex<T>>, enqueued: ArrayList<Vertex<T>>, visited: ArrayList<Vertex<T>>){
        val vertex = queue.dequeue() ?: return

        visited.add(vertex)

        val neighborEdges = edges(vertex)
        neighborEdges.forEach {
            if (!enqueued.contains(it.destination)){
                queue.enqueue(it.destination)
                enqueued.add(it.destination)
            }
        }

        bfs(queue, enqueued, visited)
    }

}