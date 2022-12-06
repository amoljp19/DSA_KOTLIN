package com.softaai.dsa_kotlin.graph.dfs

import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyListGraph


/**
 * Created by amoljp19 on 12/1/2022.
 * softAai Apps.
 */

fun main(){
    val depthFirstSearchGraph = DfsGraph<String>()

    val a = depthFirstSearchGraph.createVertex("A")
    val b = depthFirstSearchGraph.createVertex("B")
    val c = depthFirstSearchGraph.createVertex("C")
    val d = depthFirstSearchGraph.createVertex("D")
    val e = depthFirstSearchGraph.createVertex("E")
    val f = depthFirstSearchGraph.createVertex("F")
    val g = depthFirstSearchGraph.createVertex("G")
    val h = depthFirstSearchGraph.createVertex("H")

    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, a, b, 300.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, a, c, 500.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, a, d, 250.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, b, e, 450.0)   //to check isDiscoonected function working comment this line, after testing remove comment
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, c, f,300.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, c, g,300.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, e, f,300.0)
    depthFirstSearchGraph.add(EdgeType.UNDIRECTED, e, h,300.0)

    println(depthFirstSearchGraph)

  /*  val vertices = depthFirstSearchGraph.depthFirstSearchRecursiveWithoutStack(a)
    vertices.forEach {
        println(it.data)
    }*/

    println(depthFirstSearchGraph.hasCycle(a))  // in undirected yes it has cycle but in directed dont have cycle in above graph 

    //
}