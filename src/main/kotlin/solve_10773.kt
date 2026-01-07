import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.Stack

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))

    val count = bufReader.readLine().toInt()

    val stack = Stack<Int>()

    var sum: BigInteger = BigInteger("0")

    for (i in 0..<count) {
        val value = bufReader.readLine().toInt()
        if (value == 0) {
            stack.pop()
        } else {
            stack.push(value)
        }
    }

    while (!stack.empty()) {
        sum += stack.pop().toBigInteger()
    }

    print(sum)
}