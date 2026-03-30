import kotlin.math.pow

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (N, r, c) = input.readLine().split(" ").map { it.toInt() }.let { Triple(it[0], it[1], it[2]) }

    val result = calculateZ(N, r, c)

    output.write("${result}")
    output.close()
}

fun calculateZ(n: Int, row: Int, col: Int): Int {
    if (n == 0) return 0
    val half = (2.0.pow(n - 1.0)).toInt()

    if (row < half && col < half) {
        return calculateZ(n - 1, row, col)
    } else if (row < half && col >= half) {
        return half * half  + calculateZ(n - 1, row, col - half)
    } else if (row >= half && col < half) {
        return 2 * half * half + calculateZ(n - 1, row - half, col)
    } else {
        return 3*half*half + calculateZ(n - 1, row - half, col - half)
    }
}