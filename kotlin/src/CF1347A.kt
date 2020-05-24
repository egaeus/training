
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/contest/1347/problem/A>
 * @category implementation
 * @date 22/05/2020
 **/

fun main() {
    val a = readLine()!!.toInt()
    repeat(a) {
        println(readLine()!!.split(" ").map { a -> a.toInt() }.sum())
    }
}