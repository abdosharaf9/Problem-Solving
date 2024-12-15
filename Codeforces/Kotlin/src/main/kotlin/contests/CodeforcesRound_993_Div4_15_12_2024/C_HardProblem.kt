package contests.CodeforcesRound_993_Div4_15_12_2024

fun main() {
    repeat(readln().toInt()) {
        var (m, a, b, c) = readln().split(" ").map { it.toInt() }
        a = minOf(a, m)
        b = minOf(b, m)
        println(minOf(2 * m, a + b + c))
    }
}

/*
fun main() {
    repeat(readln().toInt()) {
        var (m, a, b, c) = readln().split(" ").map { it.toInt() }

        var res = 0
        if (m >= a) {
            res += a

            val rem = m - a
            if (rem >= c) {
                res += c
                c = 0
            } else {
                res += rem
                c -= rem
            }
        } else {
            res += m
        }

        if (m >= b) {
            res += b

            if (c != 0) {
                val rem = m - b
                res += if (rem >= c) c else rem
            }
        } else {
            res += m
        }

        println(res)
    }
}*/
