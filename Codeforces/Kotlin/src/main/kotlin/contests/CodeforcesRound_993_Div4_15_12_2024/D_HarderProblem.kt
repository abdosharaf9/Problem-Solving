package contests.CodeforcesRound_993_Div4_15_12_2024

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()

        val setA = (1..n).toMutableSet()
        val listA = readln().split(" ").map { it.toInt() }
        for (num in listA) {
            setA.remove(num)
        }

        val listB = mutableListOf<Int>()
        val setB = mutableSetOf<Int>()

        for (num in listA) {
            if (setB.contains(num)) {
                val x = setA.first()
                setA.remove(x)
                listB.add(x)
                continue
            }

            listB.add(num)
            setB.add(num)
        }

        for (num in listB) {
            print("$num ")
        }
        println()
    }
}