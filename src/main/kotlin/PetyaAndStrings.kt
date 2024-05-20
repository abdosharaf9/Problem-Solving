package problems

/* Problem Link: https://codeforces.com/problemset/problem/112/A */

fun main() {
    val s1 = readln()
    val s2 = readln()

    for (i in s1.indices) {
        if(s1[i].lowercase() > s2[i].lowercase()) {
            print(1)
            return
        } else if(s1[i].lowercase() < s2[i].lowercase()) {
            print(-1)
            return
        }
    }

    print(0)
}