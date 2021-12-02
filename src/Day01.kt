fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("input/day1/test")
    check(part1(testInput) == 10)

    val input = readInput("input/day1/data")
    println(part1(testInput))
    println(part2(input))
}
