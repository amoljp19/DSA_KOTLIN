package com.softaai.dsa_kotlin.graph.prims

import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyListGraph


/**
 * Created by amoljp19 on 12/4/2022.
 * softAai Apps.
 */

fun main(){

    val graph = AdjacencyListGraph<Int>()
    val one = graph.createVertex(1)
    val two = graph.createVertex(2)
    val three = graph.createVertex(3)
    val four = graph.createVertex(4)
    val five = graph.createVertex(5)
    val six = graph.createVertex(6)

    graph.add(EdgeType.UNDIRECTED, one, two, 6.0)
    graph.add(EdgeType.UNDIRECTED, one, three, 1.0)
    graph.add(EdgeType.UNDIRECTED, one, four, 5.0)
    graph.add(EdgeType.UNDIRECTED, two, three, 5.0)
    graph.add(EdgeType.UNDIRECTED, two, five, 3.0)
    graph.add(EdgeType.UNDIRECTED, three, four, 5.0)
    graph.add(EdgeType.UNDIRECTED, three, five, 6.0)
    graph.add(EdgeType.UNDIRECTED, three, six, 4.0)
    graph.add(EdgeType.UNDIRECTED, four, six, 2.0)
    graph.add(EdgeType.UNDIRECTED, five, six, 6.0)

    val (cost, mst) = Prims.produceMinimumSpaningTree(graph)
    println("Cost : $cost")
    println("MST : ")
    println("$mst")
}