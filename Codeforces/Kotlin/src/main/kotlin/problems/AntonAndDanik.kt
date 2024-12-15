package problems.problems

/* Problem Link:  */

fun main() {
    val n = readln().toInt()
    val results = readln()
    val anton = results.count { it == 'A' }
    val danik = results.length - anton
    print(if (anton > danik) "Anton" else if (anton == danik) "Friendship" else "Danik")
}