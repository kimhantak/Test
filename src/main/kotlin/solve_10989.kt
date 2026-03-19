fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()

    val countList = Array(10001) { 0 }
    repeat(count) {
        input.readLine().toInt().apply { countList[this] += 1 }
    }

    repeat(countList.size) { index ->
        repeat(countList[index]) {
            output.write("${index}\n")
        }
    }

    output.flush()
    output.close()
}