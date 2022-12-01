package com.softaai.dsa_kotlin.graph.adjacencymatrix

import com.softaai.dsa_kotlin.graph.Edge
import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.Graph
import com.softaai.dsa_kotlin.graph.Vertex


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */

class AdjacencyMatrixGraph<T> : Graph<T> {
    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override val allVertices: ArrayList<Vertex<T>>
    get() = vertices

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }
        weights.add(row)
        return vertex
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        val verticesDescription = vertices
            .joinToString(separator = "\n") { "${it.index}: ${it.data}" }

        val grid = weights.map { row ->
            buildString {
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) {
                        append("$value\t")
                    } else {
                        append("ø\t\t")
                    }
                }
            }
        }

        val edgesDescription = grid.joinToString("\n")
        return "$verticesDescription\n\n$edgesDescription"
    }

    override fun addDirectedEdges(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        weights[source.index][destination.index] = weight
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

    override fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        TODO("Not yet implemented")
    }
}