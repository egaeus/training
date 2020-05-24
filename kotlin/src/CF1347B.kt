/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @url <https://codeforces.com/contest/1347/problem/B>
 * @category geom
 * @date 22/05/2020
 **/

fun main() {
    var N = readLine()!!.toInt()
    repeat(N) {
        var A = readLine()!!.split(" ").map { x -> x!!.toInt() }.sorted()
        var B = readLine()!!.split(" ").map { x -> x!!.toInt() }.sorted()
        var ws = false
        repeat(2) { i ->
            run {
                repeat(2) { j ->
                    run {
                        if (A[i] == B[j] && A[(i + 1) % 2] + B[(j + 1) % 2] == A[i])
                            ws = true
                    }
                }
            }
        }
        println(if (ws) "Yes" else "No")
    }
}