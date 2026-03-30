fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (K, N) = input.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] }

    val list = Array<Long>(K, { 0 })
    var max: Long = -1
    repeat(K) { index ->
        input.readLine().toLong().apply {
            list[index] = this
            if (max < this) {
                max = this
            }
        }
    }

    var left: Long = 1
    var right: Long = max
    while (left <= right) {
        val mid: Long = (left + right) / 2
        var count: Long = 0
        list.forEach { value ->
            count  += value / mid
        }

        if (count >= N) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    val result = right

    output.write("${result}")
    output.close()
}