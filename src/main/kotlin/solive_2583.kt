fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (y, x, count) = input.readLine().split(" ").map { it.toInt() }.let { Triple(it[0], it[1], it[2]) }

    val array = MutableList(y) { MutableList<Int>(x) { 0 } }

    repeat(count) {
        val boundary = input.readLine().split(" ").map { it.toInt() }

        val x1 = boundary[0]
        val y1 = boundary[1]
        val x2 = boundary[2]
        val y2 = boundary[3]

        for (ty in y1..<y2) {
            for (tx in x1..<x2) {
                array[ty][tx] = 1
            }
        }
    }

    val visited = MutableList(y) { MutableList(x) { false } }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(-1, 0, 1, 0)

    val result = mutableListOf<Int>()

    for (ty in 0..<y) {
        for (tx in 0..<x) {
            if (array[ty][tx] == 0 && visited[ty][tx] == false) {
                queue.addLast(ty to tx)
                visited[ty][tx] = true
                var size = 1

                while (queue.isNotEmpty()) {
                    val target = queue.removeFirst()
                    for (i in 0..3) {
                        val iy = target.first + dy[i]
                        val ix = target.second + dx[i]

                        if (iy in 0..<y && ix in 0..<x && visited[iy][ix] == false && array[iy][ix] == 0) {
                            queue.addLast(iy to ix)
                            visited[iy][ix] = true
                            size += 1
                        }
                    }
                }

                result.add(size)
            }
        }
    }

    output.write("${result.size}\n")
    result.sorted().forEach { output.write("${it} ") }
    output.close()
}