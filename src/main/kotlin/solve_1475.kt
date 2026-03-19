import kotlin.math.ceil
import kotlin.math.max

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var value = input.readLine().toInt()

    val list = Array<Int>(10, { 0 })

    while (value != 0) {
        list[value % 10]++
        value /= 10
    }

    val mid1 = list.filterIndexed { index, i -> index != 6 && index != 9 }.max()
    val mid2 = ceil((list[6] + list[9]).toFloat() / 2).toInt()

    val result = max(mid1, mid2)

    output.write("$result")
    output.close()
}