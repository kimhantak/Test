fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()
    val CONSTRAINT = 100

    val list = Array<Int>(CONSTRAINT * 2 + 1, { 0 })

    input.readLine().split(" ").map { it.toInt() }.forEach { list[it + CONSTRAINT]++ }

    val find = input.readLine().toInt() + CONSTRAINT

    output.write("${list[find]}")

    output.close()
}