package problems.PalindromeLinkedList

// https://leetcode.com/problems/palindrome-linked-list/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        val list = mutableListOf<Int>()
        var cur = head

        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }

        var i = 0
        var j = list.lastIndex
        while (i < j) {
            if (list[i] != list[j]) return false

            i++
            j--
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    val head = ListNode(1).also {
        it.next = ListNode(2).also { it2 ->
            it2.next = ListNode(2).also { it3 ->
                it3.next = ListNode(1)
            }
        }
    }

    println(sol.isPalindrome(head))


    head.`val` = 1
    head.next = ListNode(2)
    println(sol.isPalindrome(head))
}