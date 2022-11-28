package com.softaai.dsa_kotlin.graph


/**
 * Created by amoljp19 on 11/28/2022.
 * softAai Apps.
 */

data class Edge<T>(val source: Vertex<T>, val destination: Vertex<T>, val weight: Double? = null)
