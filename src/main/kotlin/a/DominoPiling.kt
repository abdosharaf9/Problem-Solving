package a

fun main() {
    val inputs = readln().split(" ").map { it.toInt() }
    print((inputs[0] * inputs[1]) / 2)
}