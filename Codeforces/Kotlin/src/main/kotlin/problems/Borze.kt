package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/32/B */

fun main() {
    val code = readln()
    var ternaryOutput = ""

    var i = 0
    while (i in code.indices) {
        if (code[i] == '.') ternaryOutput += '0'
        else if (code[i] == '-' && code[i + 1] == '.') {
            ternaryOutput += '1'
            i++
        } else if (code[i] == '-' && code[i + 1] == '-') {
            ternaryOutput += '2'
            i++
        }

        i++
    }

    print(ternaryOutput)
}