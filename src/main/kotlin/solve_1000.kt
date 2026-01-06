fun main() {
    val result: Int = readlnOrNull().toString().split(" ").sumOf { it.toInt() }
    print(result)
}