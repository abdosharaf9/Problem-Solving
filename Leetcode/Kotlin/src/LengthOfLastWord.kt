// https://leetcode.com/problems/length-of-last-word/

fun lengthOfLastWord(s: String): Int {
    val temp = s.split(' ').filter { it.isNotEmpty() }
    return temp.last().length
}

fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
}