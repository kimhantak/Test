fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine().toInt()

    val temp = input.readLine().split(" ").map { it.toInt() }
    val result = temp.toSet().sorted().mapIndexed { index, i -> i to index }.toMap()

    val builder = StringBuilder()
    temp.forEach { value ->
        builder.append("${result.getValue(value)}")
        builder.append(" ")
    }

    output.write(builder.toString())
    output.flush()
    output.close()
}