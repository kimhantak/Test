import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val queue = ArrayDeque<Int>()

    val count = bufReader.readLine().toInt()

    repeat(count) {
        val method = bufReader.readLine().split(" ")

        when (method.first()) {
            "push" -> queue.addLast(method.last().toInt())
            "pop" -> bufWriter.write(if (queue.isEmpty()) "-1\n" else queue.removeFirst().toString() + "\n")
            "size" -> bufWriter.write(queue.size.toString() + "\n")
            "empty" -> bufWriter.write(if (queue.isEmpty()) "1\n" else "0\n")
            "front" -> bufWriter.write(if (queue.isEmpty()) "-1\n" else queue.first().toString() + "\n")
            "back" -> bufWriter.write(if (queue.isEmpty()) "-1\n" else queue.last().toString() + "\n")
        }
    }

    bufWriter.close()
}