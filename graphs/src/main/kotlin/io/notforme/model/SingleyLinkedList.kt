package io.notforme.model

class SinglyLinkedList() {
    var head: Node?
    var tail: Node?

    companion object {
        fun printSinglyLinkedList(node: SinglyLinkedList.Node?, sep: String) {
            var node = node
            while (node != null) {
                println(node.data)

                node = node.next

                if (node != null) {
                    println(sep)
                }
            }
        }

        fun mergeLists(head1: SinglyLinkedList.Node?, head2: SinglyLinkedList.Node?): SinglyLinkedList.Node? {
            var head1Cursor = head1
            var head2Cursor = head2
            var head: SinglyLinkedList.Node? = null
            var cursor: SinglyLinkedList.Node? = null

            while (head1Cursor != null && head2Cursor != null) {
                val newNode: SinglyLinkedList.Node
                if (head1Cursor.data <= head2Cursor.data) {
                    newNode = SinglyLinkedList.Node(head1Cursor.data)
                    head1Cursor = head1Cursor.next
                } else {
                    newNode = SinglyLinkedList.Node(head2Cursor.data)
                    head2Cursor = head2Cursor.next
                }

                if (head == null) {
                    head = newNode
                    cursor = head
                } else {
                    cursor!!.next = newNode
                    cursor = newNode
                }
            }

            val left = head1Cursor ?: head2Cursor
            while (left != null) {
                val newNode = SinglyLinkedList.Node(left.data)
                if (head == null) {
                    head = newNode
                    cursor = head
                } else {
                    cursor!!.next = newNode
                    cursor = newNode
                }

                left.next = left
            }

            return head
        }
    }

    init {
        this.head = null
        this.tail = null
    }

    fun insertNode(nodeData: Int) {
        val node = Node(nodeData)

        if (this.head == null) {
            this.head = node
        } else {
            this.tail!!.next = node
        }

        this.tail = node
    }

    class Node(val data: Int) {
        var next: Node? = null

        init {
            this.next = null
        }
    }


}