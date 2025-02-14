package problems.ProductOfTheLastKNumbers

// https://leetcode.com/problems/product-of-the-last-k-numbers/

// Time: O(1)
// Space: O(n)
private class ProductOfNumbers() {

    // Store the products, not the numbers itself using the Prefix Sum (Product here).
    private val stream = mutableListOf<Int>(1)

    fun add(num: Int) {
        // If the current number is 0, all the products before it will be 0,
        // so we remove all of them and add 1 as the initial value of new products.
        if (num == 0) {
            stream.clear()
            stream.add(1)
        } else {
            // Add the Prefix Sum (Product here) with the current number.
            stream.add(num * stream.last())
        }
    }

    fun getProduct(k: Int): Int {
        // If the current size is smaller than or equal to k, this means we need
        // the product of the values that contained 0, and we removed them; then
        // the result will be 0.
        return if (stream.size <= k) {
            0
        } else {
            // The result will be the last product divided by the product before the
            // kth item from the end.
            stream.last() / stream[stream.lastIndex - k]
        }
    }

}

// Time: O(1)
// Space: O(n)
/*private class ProductOfNumbers() {

    // Store the products, not the numbers itself using the Prefix Sum (Product here).
    private val stream = mutableListOf<Int>(1)
    // Store the index of the last 0, because if it is included in the range we need,
    // the product will be 0
    private var lastZero = -1

    fun add(num: Int) {
        // Update the value of the last 0.
        if (num == 0) {
            lastZero = stream.size
        }

        // If the previous number was 0, add the current item as it is and start a new product.
        if (stream.last() == 0) {
            stream.add(num)
        } else {
            // Add the previous product multiplied by the current number.
            stream.add(num * stream.last())
        }
    }

    fun getProduct(k: Int): Int {
        // If there is a 0 in the range we need, the result will be 0.
        if (lastZero >= stream.size - k) {
            return 0
        }

        val lastIdx = stream.lastIndex
        return if (stream[lastIdx - k] == 0) {
            // If the product of the numbers before the kth number from the end is 0,
            // the result will be the last product.
            stream[lastIdx]
        } else {
            // Return the last product and remove from it the product of the numbers
            // before the kth number from the end.
            stream[lastIdx] / stream[lastIdx - k]
        }
    }

}*/

// Time: O(n)
// Space: O(n)
/*private class ProductOfNumbers() {

    // Store the products, not the numbers itself using the Prefix Sum (Product here).
    private val stream = mutableListOf<Int>()

    fun add(num: Int) {
        // Add the current item to the previous products before adding it.
        for (i in stream.indices) {
            stream[i] *= num
        }

        // Add the item to the list.
        stream.add(num)
    }

    fun getProduct(k: Int): Int {
        // Get the index of the kth from end product, which is the product of the
        // last k numbers.
        val idx = stream.lastIndex
        return stream[idx - k + 1]
    }

}*/

fun main() {
    val obj = ProductOfNumbers()
    println(obj.add(3))
    println(obj.add(0))
    println(obj.add(2))
    println(obj.add(5))
    println(obj.add(4))
    println(obj.getProduct(2))
    println(obj.getProduct(3))
    println(obj.getProduct(4))
    println(obj.add(8))
    println(obj.getProduct(2))
}