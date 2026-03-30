fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val N = input.readLine().toInt()
    val list = mutableSetOf<Int>()
    input.readLine().split(" ").map { it.toInt() }.forEach { list.add(it) }

    val M = input.readLine().toInt()
    val result = Array(M) { 0 }

    input.readLine().split(" ").map { it.toInt() }.forEachIndexed { index, value ->
        if (list.contains(value)) {
          result[index] = 1
        }
    }

    output.write("${result.joinToString(separator = " ")}")
    output.close()
}