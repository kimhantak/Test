fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (K, V) = input.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] - 1 }

    val list = IntRange(1, K).toMutableList()

    val result = mutableListOf<Int>()

    var cursor = V
    while (list.size != 1) {
        result.add(list[cursor]).apply { list.removeAt(cursor) }
        cursor = (cursor + V) % list.size
    }
    result.add(list[0])

    output.write(result.joinToString(separator = ", ", prefix = "<", postfix = ">"))
    output.close()
}