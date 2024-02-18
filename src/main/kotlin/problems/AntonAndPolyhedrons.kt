package problems

/* Problem Link: https://codeforces.com/problemset/problem/785/A */

fun main() {
    val faces = mapOf(
        "Tetrahedron" to 4,
        "Cube" to 6,
        "Octahedron" to 8,
        "Dodecahedron" to 12,
        "Icosahedron" to 20
    )
    val n = readln().toInt()
    var result = 0

    for (i in 1..n) {
        result += faces[readln()]!!
    }

    print(result)
}