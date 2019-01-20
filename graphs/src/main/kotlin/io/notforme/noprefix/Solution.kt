package io.notforme.noprefix

import java.util.*

data class TrieNode(
        val c: Char = '-',
        var cnt: Int = 0,
        var isLeaf: Boolean = false,
        val children: MutableMap<Char, TrieNode> = HashMap()
)

fun insert(root: TrieNode, keyword: String): Boolean {
    var cur: TrieNode = root
    var idx = 0
    for (c in keyword) {
        val child = cur.children.getOrDefault(c, TrieNode(c = c))
        child.cnt++

        if (child.isLeaf) {
            return false
        }

        if (keyword.length - 1 == idx && child.children.isNotEmpty()) {
            return false
        }
        cur.children[c] = child
        cur = child
        idx++
    }
    cur.isLeaf = true
    return true
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val testCnt = scanner.nextLine().toInt()

    val root = TrieNode()
    var prefix = ""
    for (i in 0 until testCnt) {
        val keyword = scanner.nextLine()
        if (!insert(root, keyword)) {
            prefix = keyword
            break
        }
    }

    val result = if (prefix.isNotEmpty()) "BAD" else "GOOD"
    println("$result SET")
    if (prefix.isNotEmpty()) {
        println(prefix)
    }
}
