import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val values = bufReader.readLine().split(" ").map { it.toInt() }

    val queue = ArrayDeque<Int>()

    repeat(values.first()) { queue.addLast(it + 1) }

    val list = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        repeat(values.last().toInt() - 1) {
            queue.addLast(queue.removeFirst())
        }
        list.add(queue.removeFirst())
    }

    bufWriter.write(
        list.joinToString(
            separator = ", ",
            prefix = "<",
            postfix = ">"
        )
    )

    bufWriter.close()
}