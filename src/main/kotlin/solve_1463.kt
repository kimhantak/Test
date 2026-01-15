import kotlin.math.min

fun main() {
    val bufReader = System.`in`.bufferedReader()
    val bufWriter = System.out.bufferedWriter()

    val value = bufReader.readLine().toInt()

    val dp = Array(value + 1) { 0 }

    for (i in 2..value) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0)
            dp[i] = min(dp[i], dp[i/2] + 1)
        if (i % 3 == 0)
            dp[i] = min(dp[i], dp[i/3] + 1)
    }

    bufWriter.write("${dp[value]}")

    bufWriter.close()
}