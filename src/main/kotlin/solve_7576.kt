fun main() {
    val bufReader = System.`in`.bufferedReader()
    val bufWriter = System.out.bufferedWriter()

    val (width, height) = bufReader.readLine().split(" ").run { first().toInt() to last().toInt() }

    val graph = Array(height) { bufReader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val visited = Array(height) { IntArray(width) { 0 } }

    var unRipe = 0

    val queue = ArrayDeque<Pair<Int, Int>>()

    val direction = arrayOf(
        -1 to 0, 0 to -1, 1 to 0, 0 to 1
    )

    for (i in 0 until height) {
        for (j in 0 until width) {
            when (graph[i][j]) {
                1 -> queue.addLast(i to j)
                0 -> unRipe++
            }
        }
    }

    var day = 0

    while (queue.isNotEmpty()) {
        val (dx, dy) = queue.removeFirst()

        day = visited[dx][dy]

        for (dir in direction) {
            val (nx, ny) = dx + dir.first to dy + dir.second

            if (nx !in 0 until height || ny !in 0 until width) continue
            if (graph[nx][ny] != 0 || visited[nx][ny] != 0) continue

            unRipe--
            queue.add(nx to ny)
            visited[nx][ny] = day + 1
        }
    }

    if (0 < unRipe)
        bufWriter.write("${-1}\n")
    else
        bufWriter.write("${day}\n")

    bufWriter.close()
}