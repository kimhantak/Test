import kotlin.math.abs

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val list = Array<Int>(26) { 0 }

    val text1 = input.readLine()
    val text2 = input.readLine()

    text1.forEach { list[it.code - 'a'.code]++ }
    text2.forEach { list[it.code - 'a'.code]-- }

    val result = list.map { abs(it) }.sum()

    output.write("$result")
    output.close()
}