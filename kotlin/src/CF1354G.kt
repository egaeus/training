import java.util.stream.IntStream
import kotlin.random.Random

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readString() = readLn() // single of strings
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/>
 * @category binary search
 * @date 22/05/2020
 **/

fun main() {
    var T = readInt()
    var random = Random(1245)
    repeat(T) {
        var (N, K) = readInts()
        var first = false
        repeat(30) {
            if (!first) {
                println("? 1 1")
                println(1)
                println(random.nextInt(2, N + 1))
                System.out.flush()
                if (readString() == "SECOND") {
                    first = true
                }
            }
        }
        if (first) {
            println("! 1")
            System.out.flush()
        } else {
            var size = 1
            var ws = true
            while (size <= N && ws) {
                var realSize = minOf(size, minOf(2 * size, N) - size)
                println("? $realSize $realSize")
                println((1..realSize).joinToString(separator = " "))
                println((size + 1..minOf(2 * size, N)).joinToString(separator = " "))
                System.out.flush()
                if (readString() == "FIRST") {
                    ws = false
                    var a = size + 1
                    var b = minOf(2 * size, N);
                    while (a < b) {
                        var p = (a + b) / 2
                        realSize = p - a + 1
                        println("? $realSize $realSize")
                        println((1..realSize).joinToString(separator = " "))
                        println((a until a+realSize).joinToString(separator = " "))
                        System.out.flush()
                        if (readString() == "FIRST") {
                            b = p
                        } else a = p + 1
                    }
                    println("! $a")
                    System.out.flush()
                }
                size *= 2
            }
        }
    }
}