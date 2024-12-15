package contests.CodeforcesRound_993_Div4_15_12_2024

fun main() {
    repeat(readln().toInt()) {
        val str = readln()
        val res = StringBuilder()

        for (i in str.indices.reversed()) {
            when (str[i]) {
                'w' -> res.append('w')
                'p' -> res.append('q')
                else -> res.append('p')
            }
        }

        println(res.toString())
    }
}