fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val list = mutableListOf<Int>()

    val count = input.readLine().toInt()
    repeat(count) {
        val temp = input.readLine().toInt()
        list.add(temp)
    }

    list.sorted().forEach {
        output.write("${it}\n")
    }
    output.close()
}