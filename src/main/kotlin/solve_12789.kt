import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val count = bufReader.readLine()

    var num = 1

    val stack = Stack<Int>()

    bufReader.readLine().split(" ").map { it.toInt() }.forEach { it ->
        if (it == num) {
            num++
        } else {
            while (stack.isNotEmpty()) {
                if (stack.peek() == num) {
                    stack.pop()
                    num++
                } else {
                    break
                }
            }
            stack.push(it)
        }
    }

    while (stack.isNotEmpty()) {
        if (stack.pop() == num) {
            num++
        } else {
            break
        }
    }

    if (stack.empty()) {
        bufWriter.write("Nice")
    } else {
        bufWriter.write("Sad")
    }

    bufWriter.flush()
    bufWriter.close()
}