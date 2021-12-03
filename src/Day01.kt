fun main() {
    val testInput = readInput("input/day1/test")
    val input = readInput("input/day1/data")

    var previousDepth = Int.MAX_VALUE
    var increased = 0
    for (depth in input.map { it.trim().toInt() }) {
        if (depth > previousDepth) {
            ++increased
        }
        previousDepth = depth
    }
    println("The depth has increased $increased times")
}
