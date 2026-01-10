import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val bufReader = System.`in`.bufferedReader()
    val bufWriter = System.out.bufferedWriter()

    val computerCount = bufReader.readLine().toInt()

    val count = bufReader.readLine().toInt()

    val graph = ArrayList<ArrayList<Int>>()
    repeat(computerCount + 1) {
        graph.add(ArrayList<Int>())
    }

    repeat(count) {
        val tokenizer = StringTokenizer(bufReader.readLine())
        val (u, v) = tokenizer.nextToken().toInt() to tokenizer.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = BooleanArray(computerCount + 1) { false }

    val queue = ArrayDeque<Int>()

    var infectionCount = 0

    visited[1] = true
    queue.add(1)
    while (queue.isNotEmpty()) {
        val target = graph[queue.removeFirst()]
        for (iterator in target) {
            if (!visited[iterator]) {
                visited[iterator] = true
                infectionCount++
                queue.add(iterator)
            }
        }
    }

    bufWriter.write("${infectionCount}")

    bufWriter.close()
}