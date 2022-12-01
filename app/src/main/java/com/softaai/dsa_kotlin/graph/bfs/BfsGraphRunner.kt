package com.softaai.dsa_kotlin.graph.bfs

import com.softaai.dsa_kotlin.graph.EdgeType
import com.softaai.dsa_kotlin.graph.adjacencylist.AdjacencyListGraph


/**
 * Created by amoljp19 on 12/1/2022.
 * softAai Apps.
 */

fun main(){
    val breadthFirstSearchGraph = BfsGraph<String>()

    val a = breadthFirstSearchGraph.createVertex("A")
    val b = breadthFirstSearchGraph.createVertex("B")
    val c = breadthFirstSearchGraph.createVertex("C")
    val d = breadthFirstSearchGraph.createVertex("D")
    val e = breadthFirstSearchGraph.createVertex("E")
    val f = breadthFirstSearchGraph.createVertex("F")
    val g = breadthFirstSearchGraph.createVertex("G")
    val h = breadthFirstSearchGraph.createVertex("H")

    breadthFirstSearchGraph.add(EdgeType.DIRECTED, a, b, 300.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, a, c, 500.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, a, d, 250.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, b, e, 450.0)   //to check isDiscoonected function working comment this line, after testing remove comment
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, c, f,300.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, c, g,300.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, e, f,300.0)
    breadthFirstSearchGraph.add(EdgeType.DIRECTED, e, h,300.0)

    //println(breadthFirstSearchGraph)

    //println(breadthFirstSearchGraph.breadthFirstSearch(a))

    /*val vertices = breadthFirstSearchGraph.breadthFirstSearch(a)

    vertices.forEach {
        println(it.data)
    }

    println("-------------------------------------------")

    val vertices1 = breadthFirstSearchGraph.breadthFirstSearchUsingRecursion(a)
    vertices1.forEach {
        println(it.data)
    }


*/


    // println(breadthFirstSearchGraph.isDisconnectedGraph())

    /* val breadthFirstSearchChallenge1Graph = AdjacencyListGraph<String>()

     val a = breadthFirstSearchChallenge1Graph.createVertex("A")
     val b = breadthFirstSearchChallenge1Graph.createVertex("B")
     val c = breadthFirstSearchChallenge1Graph.createVertex("C")
     val d = breadthFirstSearchChallenge1Graph.createVertex("D")
     val e = breadthFirstSearchChallenge1Graph.createVertex("E")
     val f = breadthFirstSearchChallenge1Graph.createVertex("F")
     val g = breadthFirstSearchChallenge1Graph.createVertex("G")
     val h = breadthFirstSearchChallenge1Graph.createVertex("H")
     val i = breadthFirstSearchChallenge1Graph.createVertex("I")
     val j = breadthFirstSearchChallenge1Graph.createVertex("J")

     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, a, b, 300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, a, c, 500.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, a, d, 250.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, c, i, 450.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, d, i,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, i, j,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, i, g,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, i, f,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, f, g,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, f, e,300.0)
     breadthFirstSearchChallenge1Graph.add(EdgeType.UNDIRECTED, e, h,300.0)

     println(breadthFirstSearchChallenge1Graph)

     println(breadthFirstSearchChallenge1Graph.getMaximunCountInQueueEver(a))
    */

}