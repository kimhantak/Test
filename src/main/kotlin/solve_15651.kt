var visitedCards3: Int = 0
lateinit var depthCards3: Array<Int>
val resultCards3: MutableList<MutableList<Int>> = mutableListOf()

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    input.readLine().split(" ").map { it.toInt() }.also {
        visitedCards3 = it[0]
        depthCards3 = Array(it[1] + 1) { 0 }
    }

    findCombination3(0)

    resultCards3.forEach {
        output.write("${it.joinToString(" ")}\n")
    }
    output.flush()
    output.close()
}

fun findCombination3(depth: Int) {
    if (depth == depthCards3.size - 1) {
        resultCards3.add(depthCards3.filter { it != 0 }.toMutableList())
        return
    }

    for (idx in 1..visitedCards3) {
        depthCards3[depth] = idx
        findCombination3(depth + 1)
    }
}