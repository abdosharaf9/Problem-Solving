package NumberOfStepsToReduceANumberToZero

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

class Solution {
    fun numberOfSteps(num: Int): Int {
        var count = 0
        var n = num

        while(n != 0) {
            if(n % 2 == 0) n /= 2
            else n--
            count++
        }

        return count
    }
}

fun main() {
    val sol = Solution()
    println(sol.numberOfSteps(14))
    println(sol.numberOfSteps(8))
    println(sol.numberOfSteps(123))
}