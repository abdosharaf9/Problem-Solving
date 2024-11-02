package problems.AddTwoNumbers

// https://leetcode.com/problems/add-two-numbers/

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        val res = ListNode(0)
        var cur: ListNode? = res

        var h1 = l1
        var h2 = l2

        while (h1 != null || h2 != null || carry > 0) {
            val num = (h1?.`val` ?: 0) + (h2?.`val` ?: 0) + carry
            cur?.next = ListNode(num % 10)
            carry = num / 10

            h1 = h1?.next
            h2 = h2?.next
            cur = cur?.next
        }

        return res.next
    }
}

fun main() {
    val sol = Solution()

    printLinkedList(
        sol.addTwoNumbers(
            createList(intArrayOf(2, 4, 3)),
            createList(intArrayOf(5, 6, 4))
        )
    )

    printLinkedList(
        sol.addTwoNumbers(
            createList(intArrayOf(0)),
            createList(intArrayOf(0))
        )
    )

    printLinkedList(
        sol.addTwoNumbers(
            createList(intArrayOf(9, 9, 9, 9, 9, 9, 9)),
            createList(intArrayOf(9, 9, 9, 9))
        )
    )
}

private fun createList(list: IntArray): ListNode {
    val head = ListNode(list[0])
    var cur = head

    for (i in 1..list.lastIndex) {
        cur.next = ListNode(list[i])
        cur = cur.next!!
    }

    return head
}

private fun printLinkedList(head: ListNode?) {
    var cur = head

    print("[")
    while (cur != null) {
        if (cur.next != null) print("${cur.`val`}, ")
        else print(cur.`val`)

        cur = cur.next
    }
    println("]")
}