import kotlin.math.ceil

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/>
 * @category ?
 * @date 29/05/2020
 **/

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readString() = readLn() // single string

fun main() {
    var T = readInt()
    repeat(T) {
        var (N, K, x, y) = readInts()
        var X = x.toLong()
        var Y = y.toLong()
        var ints = readLongs()
        ints = ints.sorted()
        var sum = ints.sum()
        var min = 10000000000000000
        if (f(sum, N) <= K)
            min = Y
        if (ints[N - 1] <= K)
            min = 0
        var sums = 0L
        for (i in N - 1 downTo 0) {
            var v = ((N - i).toLong() * X)
            sums += ints[i]
            if (i == 0 || ints[i - 1] <= K)
                min = minOf(v, min)
            else if (f(sum - sums, N) <= K)
                min = minOf(v + Y, min)
        }
        println(min)
    }
}

fun f(p: Long, N: Int): Long {
    if (p % N == 0L)
        return p / N
    return p / N + 1
}