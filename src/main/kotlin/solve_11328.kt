fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()

    val result = Array<String>(count, { "" })

    repeat(count) { cnt ->
        with(input.readLine().split(" ").let { it[0] to it[1] }) {
            if (first.toList().sorted().equals(second.toList().sorted())) {
                result[cnt] = "Possible"
            } else {
                result[cnt] = "Impossible"
            }
        }
    }

    result.forEach { output.write(("${it}\n")) }

    output.close()
}