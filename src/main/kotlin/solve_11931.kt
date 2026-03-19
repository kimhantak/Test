fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()

    val list = mutableListOf<Int>()

    repeat(count) {
        input.readLine().toInt().apply { list.add(this) }
    }

    list.sortedByDescending { it }.forEach { output.write("${it}\n")  }
    output.close()
}