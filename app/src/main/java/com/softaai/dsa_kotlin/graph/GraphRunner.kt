package com.softaai.dsa_kotlin.graph


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */
fun main(){

    val adjacencyGraph = AdjacencyList<String>()

    val singapore = adjacencyGraph.createVertex("Singapore")
    val hongKong = adjacencyGraph.createVertex("Hong Kong")
    val tokyo = adjacencyGraph.createVertex("Tokyo")
    val detroit = adjacencyGraph.createVertex("Detroit")
    val austin = adjacencyGraph.createVertex("Austin, Texas")
    val washington = adjacencyGraph.createVertex("Washington, DC")
    val seattle = adjacencyGraph.createVertex("Seattle")
    val sanfrancisco = adjacencyGraph.createVertex("San Francisco")

    adjacencyGraph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, tokyo, washington,300.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, hongKong, sanfrancisco, 600.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, detroit, austin, 50.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, austin, washington,292.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, sanfrancisco, washington, 337.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, washington, seattle, 277.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, sanfrancisco, seattle, 218.0)
    adjacencyGraph.add(EdgeType.UNDIRECTED, austin, sanfrancisco,297.0)

    println(adjacencyGraph)


}