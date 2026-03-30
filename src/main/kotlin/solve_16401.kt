fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (M, N) = input.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] }

    val list = Array(N) { 0 }
    var max = -1
    input.readLine().split(" ").map { it.toInt() }.forEachIndexed { index, value ->
        list[index] = value
        if (max < value) {
            max = value
        }
    }

    var left = 1
    var right = max
    while (left <= right) {
        val mid = (left + right) / 2
        var count = 0
        list.forEach { count += it / mid }
        if (count >= M) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    val result = right

    output.write("${result}")
    output.close()
}