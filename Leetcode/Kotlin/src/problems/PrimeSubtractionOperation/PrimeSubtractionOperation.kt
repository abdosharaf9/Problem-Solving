package problems.PrimeSubtractionOperation

import kotlin.math.sqrt

// https://leetcode.com/problems/prime-subtraction-operation/

private class Solution {
    fun primeSubOperation(nums: IntArray): Boolean {
        fun isPrime(num: Int): Boolean {
            for (f in 2..sqrt(num.toFloat()).toInt()) {
                if (num % f == 0) return false
            }
            return true
        }

        val primes = mutableListOf(0, 0)
        for (i in 2..nums.max()) {
            if (isPrime(i)) primes.add(i)
            else primes.add(primes[i - 1])
        }

        var prev = 0
        for (num in nums) {
            val maxSub = num - prev
            if (maxSub <= 0) return false

            val largestPrime = primes[maxSub - 1]
            if (num - largestPrime <= prev) return false
            prev = num - largestPrime
        }

        return true
    }

    /*fun primeSubOperation(nums: IntArray): Boolean {
        fun isPrime(num: Int): Boolean {
            for (f in 2..sqrt(num.toFloat()).toInt()) {
                if (num % f == 0) return false
            }
            return true
        }

        val primes = (0..nums.max()).map {
            if (it == 0 || it == 1) false
            else isPrime(it)
        }

        var prev = 0
        for (num in nums) {
            val maxSub = num - prev

            var largestPrime = 0
            for (i in maxSub - 1 downTo 2) {
                if (primes[i]) {
                    largestPrime = i
                    break
                }
            }

            if (num - largestPrime <= prev) return false
            prev = num - largestPrime
        }

        return true
    }*/

    /*fun primeSubOperation(nums: IntArray): Boolean {
        fun isPrime(num: Int): Boolean {
            for (f in 2..sqrt(num.toFloat()).toInt()) {
                if (num % f == 0) return false
            }
            return true
        }

        var prev = 0
        for (num in nums) {
            val maxSub = num - prev

            var largestPrime = 0
            for (i in maxSub - 1 downTo 2) {
                if (isPrime(i)) {
                    largestPrime = i
                    break
                }
            }

            if (num - largestPrime <= prev) return false
            prev = num - largestPrime
        }

        return true
    }*/
}

fun main() {
    val sol = Solution()
//    println(sol.primeSubOperation(intArrayOf(4, 9, 6, 10)))
//    println(sol.primeSubOperation(intArrayOf(6, 8, 11, 12)))
    println(sol.primeSubOperation(intArrayOf(5, 8, 3)))
}