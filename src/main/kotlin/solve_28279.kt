import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val deque = ArrayDeque<Int>()

    val count = bufReader.readLine().toInt()

    repeat(count) {
        val method = bufReader.readLine().split(" ")

        when (method.first().toInt()) {
            1 -> deque.addFirst(method.last().toInt())
            2 -> deque.addLast(method.last().toInt())
            3 -> bufWriter.write(if (deque.isEmpty()) "-1\n" else "${deque.removeFirst()}\n")
            4 -> bufWriter.write(if (deque.isEmpty()) "-1\n" else "${deque.removeLast()}\n")
            5 -> bufWriter.write("${deque.size}\n")
            6 -> bufWriter.write(if (deque.isEmpty()) "1\n" else "0\n")
            7 -> bufWriter.write(if (deque.isEmpty()) "-1\n" else "${deque.first()}\n")
            8 -> bufWriter.write(if (deque.isEmpty()) "-1\n" else "${deque.last()}\n")
        }
    }

    bufWriter.close()
}