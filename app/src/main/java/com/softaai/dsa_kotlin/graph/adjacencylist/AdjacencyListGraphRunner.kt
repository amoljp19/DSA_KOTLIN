package com.softaai.dsa_kotlin.graph

import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyList
import com.softaai.dsa_kotlin.graph.adjacencylist.Ref


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

    /*println("sanfrancisco outgoing flights")
    println("------------------------------")
    adjacencyListGraph.edges(sanfrancisco).forEach {edges ->
        println("from : ${edges.source.data} to : ${edges.destination.data}")
    }*/



    val adjacencyListGraph1 = AdjacencyList<String>()

    val a = adjacencyListGraph1.createVertex("A")
    val b = adjacencyListGraph1.createVertex("B")
    val c = adjacencyListGraph1.createVertex("C")
    val d = adjacencyListGraph1.createVertex("D")
    val e = adjacencyListGraph1.createVertex("E")

    adjacencyListGraph1.add(EdgeType.DIRECTED, a, b, 300.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, a, c, 500.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, a, e, 250.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, a, d, 250.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, b, c, 450.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, b, d,300.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, d, e,300.0)
    adjacencyListGraph1.add(EdgeType.DIRECTED, c, e,300.0)


    println("Number of Path between ${a.data} to ${e.data}  : ${adjacencyListGraph1.numberOfPaths(a, e)}")


}



