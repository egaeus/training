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
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/4/A>
 * @category math
 * @date 22/05/2020
 **/

fun main() {
    var N = readInt()
    var ws = false
    repeat(N) { index ->
        run {
            if (index > 0 && index % 2 == 0 && (N - index) % 2 == 0)
                ws = true
        }
    }
    println(if (ws) "YES" else "NO")
}
