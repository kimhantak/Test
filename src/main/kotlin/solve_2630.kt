lateinit var colorPaper: Array<Array<Int>>
var blue = 0
var white = 0

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val size = input.readLine().toInt().apply { colorPaper = Array(this) { Array(this) { 0 } } }

    repeat(size)  { count ->
        input.readLine().split(" ").map { it.toInt() }.apply { colorPaper[count] = this.toTypedArray() }
    }

    colorCheck(0, 0, size)

    output.write("$white\n$blue")
    output.close()
}

fun colorCheck(y: Int, x: Int, size: Int) {
    val target = colorPaper[y][x]
    for (ty in y..<y+size) {
        for (tx in x..<x+size) {
            if (target != colorPaper[ty][tx]) {
                val newSize = size / 2
                for (dy in 0..<2) {
                    for (dx in 0..<2) {
                        colorCheck(y + dy * newSize, x + dx * newSize, newSize)
                    }
                }
                return
            }
        }
    }

    when (target) {
        0 -> white += 1
        1 -> blue += 1
    }
}