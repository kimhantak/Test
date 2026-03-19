var cards4 = 0
lateinit var depthCards4: Array<Int>
val resultCards4: MutableList<List<Int>> = mutableListOf()

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    input.readLine().split(" ").map { it.toInt() }.also {
        cards4 = it[0]
        depthCards4 = Array(it[1] + 1) { 0 }
    }

    findCombination4(0, 1)

    resultCards4.forEach {
        output.write("${it.joinToString(" ")}\n")
    }
    output.close()
}

fun findCombination4(depth: Int, index: Int) {
    if (depth == depthCards4.size - 1) {
        depthCards4.filter { it != 0 }.apply { resultCards4.add(this) }
        return
    }

    for (idx in index..cards4) {
        depthCards4[depth] = idx
        findCombination4(depth + 1, idx)
    }
}