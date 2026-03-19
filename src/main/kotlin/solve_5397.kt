import java.util.Stack

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val count = input.readLine().toInt()

    val result = mutableListOf<String>()

    repeat(count) {
        val text = input.readLine()

        val left = Stack<Char>()
        val right = Stack<Char>()
        val builder = StringBuilder()

        text.forEach { chr ->
            when (chr) {
                '<' -> if (left.isNotEmpty()) right.push(left.pop())
                '>' -> if (right.isNotEmpty()) left.push(right.pop())
                '-' -> if (left.isNotEmpty()) left.pop()
                else -> left.push(chr)
            }
        }

        result.add(left.joinToString("") + right.reversed().joinToString(""))
    }

    result.forEach { output.write("$it\n") }
    output.close()
}