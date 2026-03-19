lateinit var videoCode: Array<Array<Int>>
val resultOfVideoCode = StringBuilder()

fun main() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val size = input.readLine().toInt()
    videoCode = Array(size) { Array(size) { 0 } }
    repeat(size) { cnt ->
        input.readLine().map { it.digitToInt() }.apply {  videoCode[cnt] = this.toTypedArray() }
    }

    checkVideo(0, 0, size)
    output.write("${resultOfVideoCode}")
    output.close()
}

fun checkVideo(y: Int, x: Int, size: Int) {
    val target = videoCode[y][x]
    for (ty in y..<y+size) {
        for (tx in x..<x+size) {
            if (target != videoCode[ty][tx]) {
                resultOfVideoCode.append("(")
                val newSize = size / 2
                for (dy in 0..<2) {
                    for (dx in 0..<2) {
                        checkVideo(y + dy * newSize, x + dx * newSize, newSize)
                    }
                }
                resultOfVideoCode.append(")")
                return
            }
        }
    }
    resultOfVideoCode.append("${target}")
}