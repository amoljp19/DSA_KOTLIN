package com.softaai.dsa_kotlin.graph

import android.graphics.Canvas


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */

interface Graph<T> {

    fun createVertex(data : T) : Vertex<T>

    fun addDirectedEdges(source : Vertex<T>, destination : Vertex<T>, weight : Double?)

    fun addUnDirectedEdges(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun add(edge : EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun edges(source: Vertex<T>) : ArrayList<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>) : Double?

    fun breadthFirstSearch(source: Vertex<T>) : ArrayList<Vertex<T>>



}