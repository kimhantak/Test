fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val list = Array<Int>(10, { 0  })

    var sum: Long = 1

    repeat(3) {
        val value = input.readLine().toLong()
        sum *= value
    }

    sum.toString().forEach { list[it.digitToInt()]++ }

    list.forEach { output.write("${it}\n") }

    output.close()
}