package problems.problems

// Problem Link: https://codeforces.com/problemset/problem/490/A

fun main() {
    readln()

    val subjects = mapOf(
        1 to mutableListOf<Int>(),
        2 to mutableListOf<Int>(),
        3 to mutableListOf<Int>()
    )

    readln().split(" ").map { it.toInt() }.forEachIndexed { index, student ->
        subjects[student]?.add(index + 1)
    }

    val min = subjects.values.minBy { it.size }.size
    println(min)

    for (i in 0..<min) {
        println("${subjects[1]?.get(i)} ${subjects[2]?.get(i)} ${subjects[3]?.get(i)} ")
    }

}