import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    loop@ while (true) {
        val stack = Stack<Char>()
        val sentence = bufReader.readLine()
        if (sentence.equals(".")) {
            break
        }

        for (ch in sentence) {
            when (ch) {
                '(', '[' -> stack.push(ch)
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek().equals('(')) {
                        stack.pop()
                    } else {
                        bufWriter.write("no\n")
                        continue@loop
                    }
                }
                ']' -> {
                    if (stack.isNotEmpty() && stack.peek().equals('[')) {
                        stack.pop()
                    } else {
                        bufWriter.write("no\n")
                        continue@loop
                    }
                }
            }
        }

        if (stack.empty())
            bufWriter.write("yes\n")
        else
            bufWriter.write("no\n")
    }

    bufWriter.close()
}