fun main() {
    val testInput = readInput("input/day1/test")
    val input = readInput("input/day1/data")

    //part1(input)
    part2(input)
}

private fun part1(input: List<String>) {
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

private fun part2(input: List<String>) {
    val transformedInput = input
        .map { it.trim().toInt() }
        .windowed(3) // by default doesn't keep partial windows
        .map { it.sum() }
        .map { it.toString() }
    part1(transformedInput)
}
