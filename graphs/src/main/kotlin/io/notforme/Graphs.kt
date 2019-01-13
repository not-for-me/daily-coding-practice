package io.notforme

import io.notforme.model.SinglyLinkedList
import java.util.*

class Graphs {
    fun checkMergeLists() {
        println("Please insert input...")
        val scanner = Scanner(System.`in`)
        val tests = scanner.nextInt()

        for (testsItr in 0 until tests) {
            val llist1 = SinglyLinkedList()
            val llist1Count = scanner.nextInt()
            for (i in 0 until llist1Count) {
                llist1.insertNode(scanner.nextInt())
            }

            val llist2 = SinglyLinkedList()
            val llist2Count = scanner.nextInt()
            for (i in 0 until llist2Count) {
                llist2.insertNode(scanner.nextInt())
            }

            val llist3 = SinglyLinkedList.mergeLists(llist1.head, llist2.head)
            SinglyLinkedList.printSinglyLinkedList(llist3, " ")
        }

        scanner.close()
    }
}

fun main(args: Array<String>) {
    Graphs().checkMergeLists()
}