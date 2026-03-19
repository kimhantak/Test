val output = System.out.bufferedWriter()

fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()

    hanoi(N, 1, 2, 3)

    println((1 shl N) - 1)
    output.close()
}

fun hanoi(N: Int, A: Int, B: Int, C: Int) {
    if (N == 1) {
        output.write("$A $C\n")
        return
    }

    hanoi(N - 1, A, C, B)
    output.write("$A $C\n")
    hanoi(N - 1, B, A, C)
}