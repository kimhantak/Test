import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val value = bufReader.readLine().toInt()

    val queue = ArrayDeque<Int>()

    repeat(value) { queue.addLast(value - it) }

    while (queue.size != 1) {
        queue.removeLast()
        queue.addFirst(queue.removeLast())
    }

    bufWriter.write("${queue.first()}")
    bufWriter.close()
}