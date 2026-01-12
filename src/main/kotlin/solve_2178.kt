fun main() {
    val bufReader = System.`in`.bufferedReader()
    val bufWriter = System.out.bufferedWriter()

    val (n, m) = bufReader.readLine().split(" ").run { first().toInt() to last().toInt() }

    val graph = Array(n) { bufReader.readLine().map { it - '0' } }

    val direction = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)

    val visited = Array(n) { IntArray(m) { 0 } }

    val queue = ArrayDeque<Pair<Int, Int>>()

    queue.addLast(0 to 0)
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val (dx, dy) = queue.removeFirst()

        for (dir in direction) {
            val (nx, ny) = dx + dir.first to dy + dir.second

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (graph[nx][ny] == 0 || visited[nx][ny] != 0) continue

            visited[nx][ny] = visited[dx][dy] + 1
            queue.addLast(nx to ny)
        }
    }

    bufWriter.write("${visited[n-1][m-1]}")
    bufWriter.close()
}