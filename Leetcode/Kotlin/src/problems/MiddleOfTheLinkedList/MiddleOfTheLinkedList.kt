package problems.MiddleOfTheLinkedList

// https://leetcode.com/problems/middle-of-the-linked-list/

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {
    val sol = Solution()
    println(sol.middleNode(createList(listOf(1, 2, 3, 4, 5)))?.`val`)
    println(sol.middleNode(createList(listOf(1, 2, 3, 4, 5, 6)))?.`val`)
}

private fun createList(list: List<Int>): ListNode {
    val head = ListNode(list[0])
    var cur = head

    for (i in 1..list.lastIndex) {
        cur.next = ListNode(list[i])
        cur = cur.next!!
    }

    return head
}