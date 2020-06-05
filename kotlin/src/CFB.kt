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

var S = CharArray(0)
var K1 = 0
var K2 = 0
var N = 0
var mem = arrayOfNulls<Array<Int>>(0)

fun main() {
    var T = readInt();
    repeat(T) {
        var ints = readInts()
        N = ints[0]
        K1 = ints[1]
        K2 = ints[2]
        S = readString().toCharArray()
        mem = arrayOfNulls(N)
        for (i in 0 until N)
            mem[i] = arrayOf(-1, -1)
        println(f(0, 0))
    }
}

fun f(p: Int, puseK: Int): Int {
    if (p >= N)
        return 0
    if (mem[p]!![puseK] >= 0)
        return mem[p]!![puseK]
    if (S[p] == '0')
        return f(p + 1, 0)
    var M = 0
    if (puseK == 1)
        M = f(p + 1, 0) + Math.min(K1, K2 - K1)
    else
        M = Math.max(f(p + 1, 0) + Math.min(K1, K2 - K1), f(p + 1, 1) + K1)
    mem[p]!![puseK] = M
    return M
}