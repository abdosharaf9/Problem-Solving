package a

/* Problem Link: https://codeforces.com/problemset/problem/266/B */

fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val queue = readln().toCharArray()

    for (i in 1..t) {
        var j = 0
        while (j < queue.size - 1) {
            if(queue[j] == 'B' && queue[j + 1] == 'G') {
                val temp = queue[j]
                queue[j] = queue[j + 1]
                queue[j + 1] = temp
                j++
            }

            j++
        }
    }

    print(queue)
}