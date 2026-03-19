lateinit var visitedCards2: List<Int>
lateinit var depthCards2: Array<Int>
var resultCards2 = mutableListOf<List<Int>>()

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    input.readLine().split(" ").map { it.toInt() }. also {
        val arrayCount = it[0]
        val depthCount = it[1] + 1

        visitedCards2 = IntRange(1, arrayCount).toList()
        depthCards2 = Array(depthCount) { 0 }
    }

    findCombination2(0, 1)

    output.flush()
    resultCards2.forEach {
        output.write("${it.joinToString(separator = " ")}\n")
    }
    output.close()
}

fun findCombination2(depth: Int, index: Int) {
    if (depth == depthCards2.size - 1) {
        depthCards2.filter { it != 0 }.apply { resultCards2.add(this.toList()) }
        return
    }

    for (idx in index..visitedCards2.size) {
        depthCards2[depth] = idx
        findCombination2(depth + 1, idx + 1)
    }
}