val resultCards1 = StringBuilder()
lateinit var visitedCards1: Array<Boolean>
lateinit var depthCards1: Array<Int>
lateinit var cards1: List<Int>
var N1 = 0
var M1 = 0

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    input.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] }.apply {
        N1 = first
        M1 = second
    }

    visitedCards1 = Array(N1 + 1) { false }
    depthCards1 = Array(M1 + 1) { 0 }
    cards1 = IntRange(1, N1).toList()

    findCombination(0)

    output.flush()
    output.write("${resultCards1}")
    output.close()
}

fun findCombination(depth: Int) {
    if (depth == M1) {
        depthCards1.filter { it != 0  }.joinToString(" ").apply { resultCards1.append("${this}\n") }
        return
    }

   for (card in cards1) {
       if (visitedCards1[card] == false) {
           visitedCards1[card] = true
           depthCards1[depth] = card
           findCombination(depth + 1)
           visitedCards1[card] = false
       }
   }
}