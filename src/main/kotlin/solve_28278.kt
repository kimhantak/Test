import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))

    val count = bufReader.readLine().toInt()
    val stack = Stack<Int>()

    val strBuilder = StringBuilder()

    for (i in 0..<count) {
        val token = StringTokenizer(bufReader.readLine())
        when (token.nextToken().toInt()) {
            1 -> stack.push(token.nextToken().toInt())
            2 -> {
                if (stack.empty()) {
                    //println(-1)
                    strBuilder.append("${-1}\n")
                } else {
                    //println(stack.pop())
                    strBuilder.append("${stack.pop()}\n")
                }
            }
            3 -> {
                //println(stack.size)
                strBuilder.append("${stack.size}\n")
            }
            4 -> {
                if (stack.empty()) {
                    //println(1)
                    strBuilder.append("${1}\n")
                } else {
                    //println(0)
                    strBuilder.append("${0}\n")
                }
            }
            5 -> {
                if (!stack.empty()) {
                    //println(stack.peek())
                    strBuilder.append("${stack.peek()}\n")
                } else {
                    //println(-1)
                    strBuilder.append("${-1}\n")
                }
            }
        }
    }

    print(strBuilder.toString())
}