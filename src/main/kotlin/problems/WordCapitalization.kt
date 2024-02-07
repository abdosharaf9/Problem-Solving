package problems

/* Problem Link: https://codeforces.com/problemset/problem/281/A */

fun main() {
    var word = readln()
    word = word.first().uppercase() + word.drop(1)
    print(word)
}