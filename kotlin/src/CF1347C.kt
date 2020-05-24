private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/contest/1347/problem/C>
 * @category math
 * @date 22/05/2020
 **/

fun main() {
    var T = readInt()
    repeat(T) {
        var N = readInt()
        var M = 1
        var list = arrayListOf<Int>()
        while (N > 0) {
            if (N % 10 > 0) {
                list.add((N % 10) * M)
            }
            N /= 10
            M *= 10
        }
        println(list.size)
        println(list.joinToString(transform = { a -> a.toString() }, separator = " "))
    }
}