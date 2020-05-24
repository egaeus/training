private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readString() = readLn() // single string

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/problemset/problem/71/A>
 * @category strings
 * @date 22/05/2020
 **/
 
fun main() {
    var N = readInt()
    repeat(N) {
        var str = readString()
        if(str.length<=10)
            println(str)
        else {
            var a = str[0]
            var b = (str.length - 2)
            var c = str[str.length - 1]
            println("$a$b$c")
        }
    }
}