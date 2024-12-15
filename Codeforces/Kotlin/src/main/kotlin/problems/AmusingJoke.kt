package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/141/A */

fun main() {
    val guest = readln()
    val host = readln()
    var pile = readln()
    var all = guest + host

    if (pile.length != all.length) print("NO")
    else {
        pile = pile.toList().sorted().joinToString()
        all = all.toList().sorted().joinToString()
        if (all == pile) print("YES")
        else print("NO")
    }
}