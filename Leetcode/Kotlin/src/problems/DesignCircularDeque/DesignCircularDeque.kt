package problems.DesignCircularDeque

// https://leetcode.com/problems/design-circular-deque/

private class MyCircularDeque(k: Int) {

    private val items = Array(k) { -1 }
    private var last = -1

    fun insertFront(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            for (i in last + 1 downTo 1) {
                items[i] = items[i - 1]
            }
            items[0] = value
            last++
            true
        }
    }

    fun insertLast(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            last++
            items[last] = value
            true
        }
    }

    fun deleteFront(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            for (i in 0..<last) {
                items[i] = items[i + 1]
            }
            last--
            true
        }
    }

    fun deleteLast(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            items[last] = -1
            last--
            true
        }
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else items[0]
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else items[last]
    }

    fun isEmpty(): Boolean {
        return last == -1
    }

    fun isFull(): Boolean {
        return last == items.lastIndex
    }

}

fun main() {
    val deq = MyCircularDeque(k = 3)
    println(deq.insertLast(1)) // true
    println(deq.insertLast(2)) // true
    println(deq.insertFront(3)) // true
    println(deq.insertFront(4)) // false
    println(deq.getRear()) // 2
    println(deq.isFull()) // true
    println(deq.deleteLast()) // true
    println(deq.insertFront(4)) // true
    println(deq.getFront()) // 4


//    val deq = MyCircularDeque(k = 8)
//    println(deq.insertFront(5))
//    println(deq.getFront())
//    println(deq.isEmpty())
//    println(deq.deleteFront())
//    println(deq.insertLast(3))
//    println(deq.getRear())
//    println(deq.insertLast(7))
//    println(deq.insertFront(7))
//    println(deq.deleteLast())
//    println(deq.insertLast(4))
//    println(deq.isEmpty())
}