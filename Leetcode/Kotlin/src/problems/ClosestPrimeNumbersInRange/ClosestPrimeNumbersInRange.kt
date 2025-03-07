package problems.ClosestPrimeNumbersInRange

import utils.printArray
import kotlin.math.sqrt

// https://leetcode.com/problems/closest-prime-numbers-in-range/

private class Solution {
    // Both solutions use Sieve of Eratosthenes, but the first one use
    // the boolean array without filtering, which is more efficient.

    // Time: O(R log log R)
    // Space: O(n)
    fun closestPrimes(left: Int, right: Int): IntArray {
        // We can't find prime numbers in this range.
        if (right < 2) {
            return intArrayOf(-1, -1)
        }

        // Using Sieve of Eratosthenes to get the prime numbers smaller than right.
        // Initialize all the numbers in our range as primes.
        val isPrime = BooleanArray(right + 1) { true }

        // 0 and 1 are not primes.
        isPrime[0] = false
        isPrime[1] = false

        // Loop from 2 until the sqrt of the right bound to cover all the number in that range.
        // This is because any number after the sqrt definitely is multiplied by a number
        // smaller than the sqrt. For example, if we have 100 which sqrt(100) = 10, any number
        // larger than 10 is a multiple of a number smaller than 10, so looping after 10 won't
        // change the result.
        // For example, take 11: 22, 33, 44,...etc. all of them are multiples of 11 and also
        // multiples of 2, 3, 4,...etc. which are smaller than the sqrt of 100 (10).
        for (i in 2..sqrt(right.toDouble()).toInt() + 1) {
            // If the current number is marked as not prime before, this
            // means its divisor also marked its multiples, so skip it.
            if (!isPrime[i]) {
                continue
            }

            // Mark all the multiples of the current number as not primes.
            for (j in i * i..right step i) {
                isPrime[j] = false
            }
        }

        // Initialize the answer, and set the difference to a big number to minimize it.
        var a = -1
        var b = -1
        var diff = Int.MAX_VALUE

        // Loop over the primes and get the two with the smallest difference.
        for (i in left..right) {
            if (!isPrime[i]) {
                continue
            }

            // If the current difference is smaller, update the answer.
            if (a != -1 && i - a < diff) {
                diff = i - a
                b = i
            }

            a = i
        }

        // If there is only a single prime number, return an invalid answer.
        if (b == -1) {
            return intArrayOf(-1, -1)
        }

        // Note that a is not updated in the last iteration correctly, so calculate it.
        return intArrayOf(b - diff, b)
    }

    // Time: O(R log log R)
    // Space: O(n)
    /*fun closestPrimes(left: Int, right: Int): IntArray {
        // We can't find prime numbers in this range.
        if (right < 2) {
            return intArrayOf(-1, -1)
        }

        // Using Sieve of Eratosthenes to get the prime numbers smaller than right.
        fun getPrimes(): List<Int> {
            // Initialize all the numbers in our range as primes.
            val isPrime = BooleanArray(right + 1) { true }

            // 0 and 1 are not primes.
            isPrime[0] = false
            isPrime[1] = false

            // Loop from 2 until the sqrt of the right bound to cover all the number in that range.
            // This is because any number after the sqrt definitely is multiplied by a number
            // smaller than the sqrt. For example, if we have 100 which sqrt(100) = 10, any number
            // larger than 10 is a multiple of a number smaller than 10, so looping after 10 won't
            // change the result.
            // For example, take 11: 22, 33, 44,...etc. all of them are multiples of 11 and also
            // multiples of 2, 3, 4,...etc. which are smaller than the sqrt of 100 (10).
            for (i in 2..sqrt(right.toDouble()).toInt() + 1) {
                // If the current number is marked as not prime before, this
                // means its divisor also marked its multiples, so skip it.
                if (!isPrime[i]) {
                    continue
                }

                // Mark all the multiples of the current number as not primes.
                for (j in i * i..right step i) {
                    isPrime[j] = false
                }
            }

            // Filter the primes' list to get the numbers between left and right only.
            val primes = mutableListOf<Int>()
            for (i in left..right) {
                if (isPrime[i]) {
                    primes.add(i)
                }
            }

            return primes
        }

        // The primes' list between left and right.
        val primes = getPrimes()

        // Initialize the answer, and set the difference to a big number to minimize it.
        var a = -1
        var b = -1
        var diff = Int.MAX_VALUE

        // Loop over the primes and get the two with the smallest difference.
        for (i in 1..primes.lastIndex) {
            val cur = primes[i] - primes[i - 1]

            // If the current difference is smaller, update the answer.
            if (cur < diff) {
                a = primes[i - 1]
                b = primes[i]
                diff = cur
            }
        }

        return intArrayOf(a, b)
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.closestPrimes(10, 19))
    printArray(sol.closestPrimes(4, 6))
}