fun main() {
    val bufReader = System.`in`.bufferedReader()
    val bufWriter = System.out.bufferedWriter()

    val size = bufReader.readLine().toInt()

    val graph = Array(size) { bufReader.readLine().map { it - '0' } }

    val visited = Array(size) { BooleanArray(size) }

    val direction = arrayOf(
        -1 to 0, 1 to 0,
        0 to -1, 0 to 1
    )

    val result = mutableListOf<Int>()

    for (i in 0 until size) {
        for (j in 0 until size) {
            if (graph[i][j] == 0 || visited[i][j] == true) {
                continue
            }

            var count = 1
            val queue = ArrayDeque<Pair<Int, Int>>()
            visited[i][j] = true
            queue.add(i to j)

            while (queue.isNotEmpty()) {

                val target = queue.removeFirst()

                for (dir in direction) {
                    val (dx, dy) = target.first + dir.first to target.second + dir.second

                    if (dx !in 0 until size || dy !in 0 until size) continue
                    if (visited[dx][dy] == true || graph[dx][dy] == 0) {
                        continue
                    }

                    count++
                    visited[dx][dy] = true
                    queue.addLast(dx to dy)
                }
            }
            result.add(count)
        }
    }

    bufWriter.write("${result.size}\n")
    result.sorted().forEach { bufWriter.write("${it}\n") }
    bufWriter.close()
}