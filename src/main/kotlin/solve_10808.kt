fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val string = input.readLine()

    val list = Array<Int>(26) { 0 }

    string.forEach { chr ->
        val diff: Int = chr.code - 'a'.code
        list[diff]++
    }

    list.forEach { output.write("$it ") }

    output.close()
}