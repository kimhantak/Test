lateinit var cards5: Array<Int>
lateinit var depthCards5: Array<Int>
lateinit var visitedCards5: Array<Boolean>
val resultCards5: MutableList<List<Int>> = mutableListOf()

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    input.readLine().split(" ").map { it.toInt() }.let {
        depthCards5 = Array(it[1] + 1) { 0 }
        visitedCards5 = Array(it[0]) { false }
        cards5 = Array(it[0]) { 0 }
    }

    input.readLine().split(" ").map { it.toInt() }.sorted().forEachIndexed { index, value ->
        cards5[index] = value
    }

    findCombination5(0)

    resultCards5.forEach {
        output.write("${it.joinToString(" ")}\n")
    }
    output.close()
}

fun findCombination5(depth: Int) {
    if (depth == depthCards5.size - 1) {
        depthCards5.filter { it != 0 }.apply { resultCards5.add(this) }
        return
    }

    for (index in 0..<cards5.size) {
        if (visitedCards5[index] == false) {
            depthCards5[depth] = cards5[index]
            visitedCards5[index] = true
            findCombination5(depth + 1)
            visitedCards5[index] = false
        }
    }
}