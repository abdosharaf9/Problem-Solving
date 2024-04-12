package problems

/* Problem Link:  */

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val digits = readln().split(" ").map { it.toInt() }.sorted()
        println(
            if (digits[1] + digits[2] >= 10) "YES"
            else "NO"
        )
    }
}