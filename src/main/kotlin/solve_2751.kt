fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()
    val array = mutableListOf<Int>()

    repeat(count) {
        array.add(input.readLine().toInt())
    }

    val result = StringBuilder()
    array.sorted().forEach { result.append("${it}\n") }

    output.write("${result}")
    output.close()
}