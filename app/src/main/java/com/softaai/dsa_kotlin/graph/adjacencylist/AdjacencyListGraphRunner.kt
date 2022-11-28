package com.softaai.dsa_kotlin.graph

import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyList


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */
fun main(){

    val adjacencyListGraph = AdjacencyList<String>()

    val singapore = adjacencyListGraph.createVertex("Singapore")
    val hongKong = adjacencyListGraph.createVertex("Hong Kong")
    val tokyo = adjacencyListGraph.createVertex("Tokyo")
    val detroit = adjacencyListGraph.createVertex("Detroit")
    val austin = adjacencyListGraph.createVertex("Austin, Texas")
    val washington = adjacencyListGraph.createVertex("Washington, DC")
    val seattle = adjacencyListGraph.createVertex("Seattle")
    val sanfrancisco = adjacencyListGraph.createVertex("San Francisco")

    adjacencyListGraph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, tokyo, washington,300.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, hongKong, sanfrancisco, 600.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, detroit, austin, 50.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, austin, washington,292.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, sanfrancisco, washington, 337.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, washington, seattle, 277.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, sanfrancisco, seattle, 218.0)
    adjacencyListGraph.add(EdgeType.UNDIRECTED, austin, sanfrancisco,297.0)

    //println(adjacencyGraph)

   // println("How much from tokyo to singapore : ${adjacencyGraph.weight(tokyo, singapore)}")

    println("sanfrancisco outgoing flights")
    println("------------------------------")
    adjacencyListGraph.edges(sanfrancisco).forEach {edges ->
        println("from : ${edges.source.data} to : ${edges.destination.data}")
    }


}