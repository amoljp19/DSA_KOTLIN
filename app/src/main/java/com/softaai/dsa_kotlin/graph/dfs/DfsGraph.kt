package com.softaai.dsa_kotlin.graph.dfs

import com.softaai.dsa_kotlin.graph.Edge
import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.Graph
import com.softaai.dsa_kotlin.graph.Vertex
import com.softaai.dsa_kotlin.stack.StackImpl


/**
 * Created by amoljp19 on 12/1/2022.
 * softAai Apps.
 */
class DfsGraph<T> : Graph<T> {

    private val adjacencies = HashMap<Vertex<T>, ArrayList<Edge<T>>>()

    override val allVertices: ArrayList<Vertex<T>>
        get() = ArrayList(adjacencies.keys)

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


    override fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        TODO("Not yet implemented")
    }

    override fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val stack = StackImpl<Vertex<T>>()
        val pushed = arrayListOf<Vertex<T>>()
        val visited = arrayListOf<Vertex<T>>()

        stack.push(source)
        pushed.add(source)
        visited.add(source)

        outer@ while (true){
          if (stack.isEmpty){
              break
          }

            val vertex = stack.peek()!!
            val neighborEdges = edges(vertex)

            if (neighborEdges.isEmpty()){
                stack.pop()
                continue
            }

            for (i in 0 until neighborEdges.size){
                val destination = neighborEdges[i].destination
                if (destination !in pushed){
                    stack.push(destination)
                    pushed.add(destination)
                    visited.add(destination)
                    continue@outer
                }
            }
            stack.pop()
        }

        return visited
    }
}