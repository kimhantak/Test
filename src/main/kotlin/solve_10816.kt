fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val nCount = input.readLine().toInt()
    val values = input.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount()

    val mCount = input.readLine().toInt()
    val builder = StringBuilder()
    input.readLine().split(" ").map { it.toInt() }.forEach { value ->
        builder.append(values.getOrDefault(value, 0))
        builder.append(" ")
    }

    output.write(builder.toString())
    output.flush()
    output.close()
}