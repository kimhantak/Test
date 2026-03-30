fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val (aSize, bSize) = input.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] }

    val list = mutableMapOf<Int, Boolean>()
    input.readLine().split(" ").map { it.toInt() }.forEach { list.put(it, false) }

    input.readLine().split(" ").map { it.toInt() }.forEach {
        if (list.containsKey(it)) {
            list[it] = true
        }
    }

    list.filter { it.value == false }.run {
        output.write("${this.size}\n")
        this.toSortedMap().forEach { output.write("${it.key} ")}
    }
    output.flush()
    output.close()
}