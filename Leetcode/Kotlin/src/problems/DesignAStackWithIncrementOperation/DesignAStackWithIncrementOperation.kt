package problems.DesignAStackWithIncrementOperation

import kotlin.math.min

// https://leetcode.com/problems/design-a-stack-with-increment-operation/

private class CustomStack(maxSize: Int) {

    private val items = mutableListOf<Int>()
    private val size = maxSize

    fun push(x: Int) {
        if (items.size < size) {
            items.add(x)
        }
    }

    fun pop(): Int {
        return if (items.isNotEmpty()) {
            val item = items.last()
            items.removeLast()
            item
        } else {
            -1
        }
    }

    fun increment(k: Int, `val`: Int) {
        if (items.isNotEmpty()) {
            for (i in 0..min(k - 1, items.lastIndex)) {
                items[i] += `val`
            }
        }
    }

}

fun main() {
    val st = CustomStack(3)
    st.push(10)
    st.push(20)
    st.push(30)
    println(st.pop())
    st.increment(50, 100)
    println(st.pop())
    println(st.pop())
}