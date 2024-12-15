package problems.problems

// Problem Link: https://codeforces.com/problemset/problem/492/A

fun main() {
    val cubes = readln().toInt()
    var countedCubes = 1
    var level = 1

    while (countedCubes < cubes) {
        level++
        countedCubes += level * (level + 1) / 2
    }

    print(
        if (countedCubes > cubes) level - 1
        else level
    )
}