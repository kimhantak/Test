fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val testCase = input.readLine().toInt()

    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(-1, 0, 1, 0)

    val result = mutableListOf<Int>()

    repeat(testCase) {
        val (y, x, count) = input.readLine().split(" ").map { it.toInt() }.let { Triple(it[1], it[0], it[2]) }

        val array = MutableList(y) { MutableList<Int>(x) { 0 } }

        repeat(count) {
            val (ty, tx) = input.readLine().split(" ").map { it.toInt() }.let { it[1] to it[0] }
            array[ty][tx] = 1
        }

        val visited = MutableList(y) { MutableList<Boolean>(x) { false } }

        var snake = 0

        val queue = ArrayDeque<Pair<Int, Int>>()

        for (ty in 0..<y) {
            for (tx in 0..<x) {
                if (array[ty][tx] == 1 && visited[ty][tx] == false) {
                    snake += 1

                    queue.addLast(ty to tx).apply { visited[ty][tx] = true }

                    while (queue.isNotEmpty()) {
                        val target = queue.removeFirst()

                        for (i in 0..3) {
                            val (ny, nx) = target.first + dy[i] to target.second + dx[i]

                            if (ny in 0..<y && nx in 0..<x && visited[ny][nx] == false && array[ny][nx] == 1) {
                                queue.addLast(ny to nx)
                                visited[ny][nx] = true
                            }
                        }
                    }
                }
            }
        }

        result.add(snake)
    }

    result.forEach { output.write("$it\n") }
    output.close()
}