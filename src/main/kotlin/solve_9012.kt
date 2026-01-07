import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))

    val count = bufReader.readLine().toInt()

    for (i in 0..<count) {
        val stack = Stack<Char>()
        val ps = bufReader.readLine()
        ps.forEach { ch ->
            if (!stack.empty() && stack.peek() == '(' && ch == ')') {
                stack.pop()
            } else {
                stack.push(ch)
            }
        }

        if (0 < stack.size) {
            println("NO")
        } else {
            println("YES")
        }
    }
}