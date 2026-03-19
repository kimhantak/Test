fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (height, width) = input.readLine().split(" ").let { it[0].toInt() to it[1].toInt() }

    val array = MutableList(height) { MutableList<Int>(width) { 0 } }

    repeat(height) { count ->
        input.readLine().split(" ").map { it.toInt() }.apply { array[count] = this.toMutableList() }
    }

    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(-1, 0, 1, 0)

    val visited = MutableList(height) { MutableList<Boolean>(width) { false } }

    val result = mutableListOf<Int>()

    for (h in 0..<height) {
        for (w in 0..<width) {
            if (visited[h][w] != true && array[h][w] == 1) {
                var size = 0
                val queue = ArrayDeque<Pair<Int, Int>>()

                visited[h][w] = true
                size += 1
                queue.addLast(h to w)

                while (queue.isNotEmpty()) {
                    val target = queue.removeFirst()
                    for (i in 0..3) {
                        val (ny, nx) = target.first + dy[i] to target.second + dx[i]
                        if ( ny in 0..<height && nx in 0..<width && visited[ny][nx] != true && array[ny][nx] != 0) {
                            queue.addLast(ny to nx)
                            visited[ny][nx] = true
                            size += 1
                        }
                    }
                }

                result.add(size)
            }
        }
    }

    output.write("${result.size}\n")
    output.write("${result.maxOrNull() ?: 0}")

    output.close()
}