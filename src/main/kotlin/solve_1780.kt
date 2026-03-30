lateinit var paper: Array<Array<Int>>
var minus = 0
var zero = 0
var plus = 0

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val size = input.readLine().toInt()

    paper = Array(size) { Array<Int>(size) { 0 } }

    repeat(size) { count ->
        input.readLine().split(" ").map { it.toInt() }.apply { paper[count] = this.toTypedArray() }
    }

    check(0, 0, size)

    output.flush()
    output.write("$minus\n$zero\n$plus")
    output.close()
}

fun check(y: Int, x: Int, size: Int) {
    val target = paper[y][x]
    for (ty in y..<y+size) {
        for (tx in x..<x+size) {
            if (target != paper[ty][tx]) {
                val newSize = size / 3
                for (j in 0..<3) {
                    for (i in 0..<3) {
                        check(y + j * newSize, x + i * newSize, newSize)
                    }
                }
                return
            }
        }
    }

    when(paper[y][x]) {
        -1 -> minus += 1
        0 -> zero += 1
        1 -> plus += 1
    }
}