fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val nCount = input.readLine().toInt()

    val values = input.readLine().split(" ").map { it.toInt() }.toSet()

    val mCount = input.readLine().toInt()

    input.readLine().split(" ").map { it.toInt() }.forEach { value ->
        when (values.contains(value)) {
            true -> output.write("1\n")
            false -> output.write("0\n")
        }
    }

    output.flush()
    output.close()
}