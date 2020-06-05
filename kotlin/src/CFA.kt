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
    var T = readInt();
    repeat(T) {
        var (N, K) = readInts()
        var N1 = N / (1 + K + K * K + K * K * K)
        var N2 = K * N1
        var N3 = K * N2
        var N4 = K * N3
        println("$N1 $N2 $N3 $N4")
    }
}