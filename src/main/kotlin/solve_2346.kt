import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val count = br.readLine().toInt()
    val deque = mutableListOf<Balloon>()
    val st = StringTokenizer(br.readLine())
    var i = 1
    while (st.hasMoreTokens()) {
        val item = st.nextToken().toInt()
        deque.add(Balloon(i, item))
        i++
    }

    var note = 0
    var countBalloons = 0

    val result = mutableListOf<Int>()

    while (deque.isNotEmpty()) {

        if (note == 0) {
            deque.removeFirst().apply {
                result.add(this.index)
                note = this.note
            }
        } else if (note > 0) {
            countBalloons += 1
            if (countBalloons != note) {
                deque.add(deque.removeFirst())
            } else {
                deque.removeFirst().apply {
                    result.add(this.index)
                    note = this.note
                    countBalloons = 0
                }
            }
        } else {
            countBalloons -= 1
            if (countBalloons != note) {
                deque.add(0, deque.removeLast())
            } else {
                deque.removeLast().apply {
                    result.add(this.index)
                    note = this.note
                    countBalloons = 0
                }
            }
        }
    }


    println(result.joinToString(" "))
}

data class Balloon(
    val index: Int,
    val note: Int
)

/*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val bufReader = BufferedReader(InputStreamReader(System.`in`))
    val bufWriter = BufferedWriter(OutputStreamWriter(System.out))

    val count = bufReader.readLine().toInt()
    val targets = StringTokenizer(bufReader.readLine())

    val deque = ArrayDeque<Pair<Int, Int>>()
    repeat(count) {
        deque.addLast(it + 1 to targets.nextToken().toInt())
    }

    val result = mutableListOf<Int>()

    var at = deque.first().second
    result.add(deque.removeFirst().first)

    while (deque.isNotEmpty()) {
        if (0 < at) {
            repeat(at - 1) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            repeat(at * (-1)) {
                deque.addFirst(deque.removeLast())
            }
        }
        at = deque.first().second
        result.add(deque.removeFirst().first)
    }

    bufWriter.write(result.joinToString(" "))
    bufWriter.close()
}
 */