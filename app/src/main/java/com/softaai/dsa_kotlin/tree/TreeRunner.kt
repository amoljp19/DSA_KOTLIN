package com.softaai.dsa_kotlin.tree


/**
 * Created by amoljp19 on 10/10/2022.
 * softAai Apps.
 */

fun main(){
   /* val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")

    val beverages = TreeNode("Beverages").run {
        add(hot)
        add(cold)
    }

    print(beverages)*/


    val tree = makeBeverageTree()
    //tree.forEachDepthFirst { println(it.value) }

    //tree.forEachLevelOrder { println(it.value) }

    tree.search("ginger ale")?.let {
        println("found node : ${it.value}")
    }

    tree.search("amol")?.let {
        println(it.value)
    } ?: println("Node amol couldnt found!!")


}


fun makeBeverageTree() : TreeNode<String>{
    val tree = TreeNode("Beverage")

    val hot = TreeNode("Hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("Tea")
    val coffee = TreeNode("Coffee")
    val chocolate = TreeNode("Chocolate")

    val blackTea = TreeNode("blackTea")
    val greenTea = TreeNode("greenTea")
    val chaiTea = TreeNode("chaiTea")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}